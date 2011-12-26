import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

public final class SoundProvider {

    private static SoundProvider instance = null;
	private final ExecutorService playerPool = Executors.newCachedThreadPool();
	private Sequencer midiSequencer;
	private Sequence midiSequence;
	
	private Clip clip;
	
    private SoundProvider() { 
		try {
			this.midiSequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
    
    /** @return the singleton instance */
    public static SoundProvider getSingleton() {
        return instance == null ? instance = new SoundProvider() : instance;
    }
    
    /** plays a MIDI sequence 
    * @param data the midi sequence bytes to be read
    */
   public void playMIDI(final byte[] data, final int loopCount){
		if (!midiSequencer.isOpen())
			try {
				midiSequencer.open();
			} catch (MidiUnavailableException e1) {
			}
		if(midiSequencer.isRunning())midiSequencer.stop();

		playerPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					midiSequence = MidiSystem.getSequence(new BufferedInputStream(new ByteArrayInputStream(data)));
					midiSequencer.setLoopCount(loopCount);
					midiSequencer.setSequence(midiSequence);
				} catch (InvalidMidiDataException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				midiSequencer.start();
			}
		});
	}

   /** plays a WAV
    * @param data the WAV bytes to be read
    */
    public void playWAV(final byte[] data, final float volumeLevel) {
         new Thread() {
			@Override
			public void run() {
				AudioInputStream audioInputStream = null;
				try {
					audioInputStream = AudioSystem
							.getAudioInputStream(new ByteArrayInputStream(data));
				} catch (UnsupportedAudioFileException e1) {
					e1.printStackTrace();
					return;
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				AudioFormat audioFormat = audioInputStream.getFormat();
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
				try {
					SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);
					dataLine.open(audioFormat);
					FloatControl volume = null;
					if (dataLine.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
						if (dataLine.isControlSupported(FloatControl.Type.VOLUME)) {
							volume = (FloatControl) dataLine.getControl(FloatControl.Type.MASTER_GAIN);
							volume = (FloatControl) dataLine.getControl(FloatControl.Type.VOLUME);
							volume.setValue(volumeLevel);
						}
					}
					dataLine.start();
					int bufferSize = (int) audioFormat.getSampleRate() * audioFormat.getFrameSize();
					byte[] buffer = new byte[bufferSize];
					try {
						int bytesRead = 0;
						while (bytesRead >= 0) {
							bytesRead = audioInputStream.read(buffer, 0, buffer.length);
							if (bytesRead >= 0) {
								dataLine.write(buffer, 0, bytesRead);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					dataLine.drain();
					dataLine.close();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		}.start();
    }

    public void playMP3(byte [] data) {
        //WILL BE EXPLAINED LATER TUTORIAL
    }
	
	private enum Position {
		LEFT, RIGHT, NORMAL
	};
}