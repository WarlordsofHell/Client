import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import sign.signlink;
/**
 *Loads models from a data file
 *
 *@author Ben
 */

public class ModelDecompressor {

	public static void loadModels() {
		try {
			DataInputStream indexFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/models.idx"));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/models.dat"));
			int length = indexFile.readInt();
			for(int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				//System.out.println("ID: "+ id +" Length: "+ invlength +" Data: "+ data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Objects() {
		try {
			DataInputStream indexFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/objects.idx"));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/objects.dat"));
			int length = indexFile.readInt();
			for(int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				//System.out.println("ID: "+ id +" Length: "+ invlength +" Data: "+ data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadOther() {
		try {
			DataInputStream indexFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/anim/Gfx.idx"));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/anim/Gfx.dat"));
			int length = indexFile.readInt();
			for(int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				//System.out.println("ID: "+ id +" Length: "+ invlength +" Data: "+ data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void loadNpcs() {
		try {
			DataInputStream indexFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/Npcs.idx"));
			DataInputStream dataFile = new DataInputStream(new FileInputStream(signlink.findcachedir()+ "nData/dModels/Npcs.dat"));
			int length = indexFile.readInt();
			for(int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				//System.out.println("ID: "+ id +" Length: "+ invlength +" Data: "+ data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}