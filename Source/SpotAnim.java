// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class SpotAnim {


    public static void unpackConfig(StreamLoader streamLoader)
    {
        Stream stream = new Stream(streamLoader.getDataForName("spotanim.dat"));
        int length = stream.readUnsignedWord();
        if(cache == null)
            cache = new SpotAnim[length];
        for(int j = 0; j < length; j++)
        {
            if(cache[j] == null)
                cache[j] = new SpotAnim();
            cache[j].anInt404 = j;
            cache[j].readValues(stream);
        }
		cache[1247] = new SpotAnim();
		cache[1247].anInt405 = 60776;
		cache[1247].anInt406 = 4001;
		cache[1247].aAnimation_407 = Animation.anims[4001];
		cache[1248] = new SpotAnim();
		cache[1248].anInt405 = 60776;
		cache[1248].anInt406 = 4002;
		cache[1248].aAnimation_407 = Animation.anims[4002];
    }

    private void readValues(Stream stream) {
	anInt406 = stream.readUnsignedWord();
	anInt405 = stream.readUnsignedWord();
		if (Animation.anims != null && anInt406 != 65535 && anInt406 != -1)
		aAnimation_407 = Animation.anims[anInt406];
		anInt410 = stream.readUnsignedByte();
		anInt411 = stream.readUnsignedByte();
	   int j = stream.readUnsignedWord();
			if(j != 65535) {
			for (int k = 0; k < j; k++)


                    anIntArray409[k] = stream.readUnsignedWord();
                        for (int k = 0; k < j; k++)
                    anIntArray408[k] = stream.readUnsignedWord();
		}
    }
	
    public Model getModel()
    {
        Model model = (Model) aMRUNodes_415.insertFromCache(anInt404);
        if(model != null)
            return model;
        model = Model.method462(anInt405);
        if(model == null)
            return null;
        for(int i = 0; i < 6; i++)
            if(anIntArray408[0] != 0)
                model.method476(anIntArray408[i], anIntArray409[i]);

        aMRUNodes_415.removeFromCache(model, anInt404);
        return model;
    }

    private SpotAnim()
    {
        anInt400 = 9;
        anInt406 = -1;
        anIntArray408 = new int[6];
        anIntArray409 = new int[6];
        anInt410 = 128;
        anInt411 = 128;
    }

    private final int anInt400;
    public static SpotAnim cache[];
    private int anInt404;
    private int anInt405;
    private int anInt406;
    public Animation aAnimation_407;
    private final int[] anIntArray408;
    private final int[] anIntArray409;
    public int anInt410;
    public int anInt411;
    public int anInt412;
    public int anInt413;
    public int anInt414;
    public static MRUNodes aMRUNodes_415 = new MRUNodes(30);

}