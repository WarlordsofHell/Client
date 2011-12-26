// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class MouseDetection
		implements Runnable
{

	public void run()
	{
		while(running) 
		{
			synchronized(syncObject)
			{
				if(coordsIndex < 500)
				{
					coordsX[coordsIndex] = ClientInstance.mouseX;
					coordsY[coordsIndex] = ClientInstance.mouseY;
					coordsIndex++;
				}
			}
			try
			{
				Thread.sleep(50L);
			}
			catch(Exception _ex) { }
		}
	}

	public MouseDetection(client Client1)
	{
		syncObject = new Object();
		coordsY = new int[500];
		running = true;
		coordsX = new int[500];
		ClientInstance = Client1;
	}

	private client ClientInstance;
	public final Object syncObject;
	public final int[] coordsY;
	public boolean running;
	public final int[] coordsX;
	public int coordsIndex;
}
