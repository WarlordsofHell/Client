import sign.signlink;
import java.util.zip.*;
import java.io.*;

public final class DataBase
{

	private static String getDir() {
		return signlink.findcachedir();
	}
	
	public static byte[][] allFrames = new byte[7000][];
	public static byte[][] allSkinlist = new byte[7000][];
	public static void loadAnimations() {
		System.out.println("Loading 602 anims");
		int i = 0;
		try {
           GZIPInputStream gzipDataFile = new GZIPInputStream(new FileInputStream(getDir() + "nData/dModels/anim/frames.dat"));
           DataInputStream dataFile = new DataInputStream(gzipDataFile);
           GZIPInputStream gzipIndexFile = new GZIPInputStream(new FileInputStream(getDir() + "nData/dModels/anim/frames.idx"));
           DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for(i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				allFrames[id]=data;
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			System.out.println("Error: "+i);
			e.printStackTrace();
		}
	
		try {
           GZIPInputStream gzipDataFile = new GZIPInputStream(new FileInputStream(getDir() + "nData/dModels/anim/skinlist.dat"));
           DataInputStream dataFile = new DataInputStream(gzipDataFile);
           GZIPInputStream gzipIndexFile = new GZIPInputStream(new FileInputStream(getDir() + "nData/dModels/anim/skinlist.idx"));
           DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for(i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				allSkinlist[id]=data;
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			System.out.println("Error: "+i);
			e.printStackTrace();
		}
	}
	
	public static byte[][] allModels = new byte[70000][];
	public static int modelList[];
}
