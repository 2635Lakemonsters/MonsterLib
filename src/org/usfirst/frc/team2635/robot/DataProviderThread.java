package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.DataProvider;

public class DataProviderThread extends Thread
{
	DataProvider<?,?> chain;
	boolean run;
	public synchronized void stopThread()
	{
		run = false;
	}
	@Override
	public void run()
	{
		boolean localRun;
		synchronized(this)
		{
			localRun = this.run;
		}
		do
		{
			chain.getData();
		}while(localRun);
	}
	public DataProviderThread(DataProvider<?,?> chain)
	{
		this.chain = chain;
		run = true;
	}
}
