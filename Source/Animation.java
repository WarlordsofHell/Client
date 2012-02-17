
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
import sign.signlink;
public final class Animation {

    public static void unpackConfig(StreamLoader streamLoader)
    {
		//Stream stream = new Stream(streamLoader.getDataForName("seq.dat"));
		Stream stream = new Stream(FileOperations.ReadFile(signlink.findcachedir() + "602seq.dat"));
        int length = stream.readUnsignedWord();
        if(anims == null)
            anims = new Animation[length + 5000];
        for(int j = 0; j < length; j++) {
            if(anims[j] == null)
                anims[j] = new Animation();
            anims[j].readValues(stream);
			try {
				anims[4000] = new Animation();
				anims[4000].anInt352 = 28;
				anims[4000].anIntArray355 = new int[]{3,2,2,2,3,3,3,3,3,2,2,2,2,2,3,3,2,1,1,3,3,3,3,3,3,3,3,3};
				anims[4000].anIntArray353 = new int[]{223019263,223019511,223019120,223019119,223019242,223019278,223019027,223019504,223019417,223019428,223019705,223019087,223019664,223019465,223019589,223019707,223019322,223019644,223019174,223019574,223019108,223019335,223019521,223019401,223019300,223019029,223019276,223019115};
				anims[4000].anIntArray357 = new int[]{9,11,13,15,17,19,165,167,169,171,173,175,177,179,9999999};
				anims[4000].anInt360 = -1;
				anims[4000].anInt361 = -1;
				
				anims[4001].anInt352 = 15;
				anims[4001].anIntArray355 = new int[]{9,3,3,3,3,3,2,2,15,4,3,3,3,3,3};
				anims[4001].anIntArray353 = new int[]{219742346,219742338,219742330,219742335,219742341,219742348,219742322,219742325,219742318,219742320,219742323,219742349,219742334,219742317,219742347};
				
				anims[4002].anInt352 = 40;
				anims[4002].anIntArray355 = new int[]{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
				anims[4002].anIntArray353 = new int[]{219742278,219742256,219742218,219742282,219742223,219742222,219742253,219742232,219742300,219742239,219742254,219742252,219742245,219742224,219742219,219742294,219742209,219742241,219742299,219742230,219742279,219742238,219742221,219742214,219742283,219742305,219742312,219742280,219742265,219742211,219742210,219742208,219742212,219742234,219742314,219742240,219742292,219742313,219742267,219742263};
	
				anims[15069] = new Animation();
				anims[15069].anInt352 = 24;
				anims[15069].anIntArray355 = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
				anims[15069].anIntArray353 = new int[] { 227803309, 227803140, 227803217, 227803251, 227803297, 227803222, 227803158, 227803280, 227803266, 227803224, 227803268, 227803288, 227803218, 227803157, 227803187, 227803152, 227803286, 227803179, 227803168, 227803229, 227803248, 227803213, 227803180, 227803284 };
				anims[15069].anInt363 = 0;
				anims[15069].anInt364 = 0;
				
				anims[15070] = new Animation();
				anims[15070].anInt352 = 24;
				anims[15070].anIntArray355 = new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };
				anims[15070].anIntArray353 = new int[] { 227803277, 227803235, 227803154, 227803141, 227803238, 227803321, 227803151, 227803203, 227803205, 227803299, 227803137, 227803262, 227803245, 227803174, 227803242, 227803139, 227803305, 227803317, 227803254, 227803167, 227803185, 227803267, 227803257, 227803265 };
				anims[15070].anInt363 = 0;
				anims[15070].anInt364 = 0;
			
				anims[15071] = new Animation();
				anims[15071].anInt352 = 16;
				anims[15071].anIntArray355 = new int[] { 4, 3, 3, 4, 4, 3, 2, 2, 1, 1, 2, 2, 3, 3, 3, 1 };
				anims[15071].anIntArray353 = new int[] { 227803302, 227803143, 227803240, 227803163, 227803159, 227803155, 227803323, 227803183, 227803276, 227803287, 227803285, 227803219, 227803210, 227803147, 227803204, 227803302 };
				anims[15071].anInt359 = 6;
				anims[15071].anInt362 = 1;
				anims[15071].anInt363 = 2;
				anims[15071].anInt364 = 2;
				
				anims[15072] = new Animation();
				anims[15072].anInt352 = 23;
				anims[15072].anIntArray355 = new int[] { 3, 4, 4, 3, 4, 2, 2, 1, 1, 1, 1, 1, 3, 3, 3, 2, 2, 2, 3, 3, 3, 4, 1 };
				anims[15072].anIntArray353 = new int[] { 227803212, 227803308, 227803199, 227803292, 227803227, 227803241, 227803271, 227803327, 227803296, 227803173, 227803314, 227803247, 227803263, 227803237, 227803243, 227803156, 227803138, 227803190, 227803198, 227803231, 227803304, 227803233, 227803212 };
				anims[15072].anInt359 = 6;
				anims[15072].anInt362 = 1;
				anims[15072].anInt363 = 2;
				anims[15072].anInt364 = 2;
				
				anims[15073] = new Animation();
				anims[15073].anInt352 = 16;
				anims[15073].anIntArray355 = new int[] { 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2 };
				anims[15073].anIntArray353 = new int[] { 227803319, 227803320, 227803223, 227803197, 227803177, 227803259, 227803211, 227803145, 227803312, 227803252, 227803279, 227803209, 227803166, 227803176, 227803207, 227803261 };
				anims[15073].anInt363 = 2;
				anims[15073].anInt364 = 2;
				
				anims[15074] = new Animation();
				anims[15074].anInt352 = 17;
				anims[15074].anIntArray355 = new int[] { 1, 2, 2, 2, 3, 3, 3, 4, 2, 1, 3, 1, 2, 2, 1, 1, 1 };
				anims[15074].anIntArray353 = new int[] { 227803221, 227803322, 227803275, 227803256, 227803283, 227803272, 227803293, 227803318, 227803303, 227803206, 227803164, 227803146, 227803289, 227803255, 227803225, 227803169, 227803221 };
				anims[15074].anInt362 = 1;
				anims[15074].anInt363 = 2;
				anims[15074].anInt364 = 2;
				
				anims[15075] = new Animation();
				anims[15075].anInt352 = 16;
				anims[15075].anIntArray355 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
				anims[15075].anIntArray353 = new int[] { 227803194, 227803226, 227803171, 227803228, 227803232, 227803136, 227803253, 227803175, 227803316, 227803162, 227803186, 227803192, 227803294, 227803144, 227803189, 227803282 };
				anims[15075].anInt363 = 0;
				anims[15075].anInt364 = 0;
				
				anims[15076] = new Animation();
				anims[15076].anInt352 = 16;
				anims[15076].anIntArray355 = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
				anims[15076].anIntArray353 = new int[] { 227803193, 227803298, 227803201, 227803234, 227803216, 227803160, 227803315, 227803306, 227803325, 227803220, 227803182, 227803149, 227803150, 227803313, 227803208, 227803258 };
				anims[15076].anInt363 = 0;
				anims[15076].anInt364 = 0;
				
				anims[15077] = new Animation();
				anims[15077].anInt352 = 16;
				anims[15077].anIntArray355 = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
				anims[15077].anIntArray353 = new int[] { 227803148, 227803326, 227803290, 227803270, 227803202, 227803269, 227803244, 227803307, 227803260, 227803153, 227803250, 227803196, 227803278, 227803246, 227803236, 227803195 };
				anims[15077].anInt363 = 0;
				anims[15077].anInt364 = 0;
			} catch (Exception _ex) {}
        }
    }

    public int method258(int i) {
        int j = anIntArray355[i];
        if(j == 0)
        {
            Class36 class36 = Class36.method531(anIntArray353[i]);
            if(class36 != null)
                j = anIntArray355[i] = class36.anInt636;
        }
        if(j == 0)
            j = 1;
        return j;
    }
	
	public void readValues(Stream stream) {
        do {
            int penorOwns = stream.readUnsignedByte();
                if (penorOwns == 0)
                    break;
                        if (penorOwns == 1) {
                                anInt352 = stream.readUnsignedWord();
                                anIntArray353 = new int[anInt352];
                                anIntArray354 = new int[anInt352];
                                anIntArray355 = new int[anInt352];
                                for (int j = 0; j < anInt352; j++) {
                                        anIntArray355[j] = stream.readUnsignedWord();
                                        anIntArray354[j] = -1;
                                }
                                for (int j = 0; j < anInt352; j++)
                                        anIntArray353[j] = stream.readUnsignedWord();
                                for (int i1 = 0; i1 < anInt352; i1++) {
                                        anIntArray353[i1] = (stream.readUnsignedWord() << 16) + anIntArray353[i1];
                                }
                        } else if (penorOwns == 2)
                                anInt356 = stream.readUnsignedWord();
                        else if (penorOwns == 3) {
                                int k = stream.readUnsignedByte();
                                anIntArray357 = new int[k + 1];
                                for (int l = 0; l < k; l++)
                                        anIntArray357[l] = stream.readUnsignedByte();
 
                                anIntArray357[k] = 0x98967f;
                        } else if (penorOwns == 4)
                                aBoolean358 = true;
                        else if (penorOwns == 5)
                                anInt359 = stream.readUnsignedByte();
                        else if (penorOwns == 6)
                                anInt360 = stream.readUnsignedWord();
                        else if (penorOwns == 7)
                                anInt361 = stream.readUnsignedWord();
                        else if (penorOwns == 8)
                                anInt362 = stream.readUnsignedByte();
                        else if (penorOwns == 9)
                                anInt363 = stream.readUnsignedByte();
                        else if (penorOwns == 10)
                                anInt364 = stream.readUnsignedByte();
                        else if (penorOwns == 11)
                                anInt365 = stream.readUnsignedByte();
                        else if (penorOwns == 12)
                                stream.readDWord();
                        else
                                System.out.println("Error unrecognised seq config code: " + penorOwns);
                } while (true);
                if (anInt352 == 0) {
                        anInt352 = 1;
                        anIntArray353 = new int[1];
                        anIntArray353[0] = -1;
                        anIntArray354 = new int[1];
                        anIntArray354[0] = -1;
                        anIntArray355 = new int[1];
                        anIntArray355[0] = -1;
                }
                if (anInt363 == -1)
                        if (anIntArray357 != null)
                                anInt363 = 2;
                        else
                                anInt363 = 0;
                if (anInt364 == -1) {
                        if (anIntArray357 != null) {
                                anInt364 = 2;
                                return;
                        }
                        anInt364 = 0;
                }
        }

    private Animation() {
        anInt356 = -1;
        aBoolean358 = false;
        anInt359 = 5;
        anInt360 = -1; //Removes shield
        anInt361 = -1; //Removes weapon
        anInt362 = 99;
        anInt363 = -1; //Stops character from moving
        anInt364 = -1;
        anInt365 = 1; 
    }

    public static Animation anims[];
    public int anInt352;
    public int anIntArray353[];
    public int anIntArray354[];
    public int[] anIntArray355;
    public int anInt356;
    public int anIntArray357[];
    public boolean aBoolean358;
    public int anInt359;
    public int anInt360;
    public int anInt361;
    public int anInt362;
    public int anInt363;
    public int anInt364;
    public int anInt365;
    public static int anInt367;
}
