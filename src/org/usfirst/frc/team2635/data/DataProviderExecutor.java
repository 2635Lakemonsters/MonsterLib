package org.usfirst.frc.team2635.data;

import java.util.List;

public class DataProviderExecutor extends D<DataProvider>
{
	List<DataProviderThread> threads;
	class DataProviderThread extends Thread
	{
		DataProvider<?,?> chain;
		boolean run;
		public void stopThread()
		{
			run = false;
		}
		@Override
		public void run()
		{
			do
			{
				chain.getData();
			}while(run);
		}
		public DataProviderThread(DataProvider<?,?> chain)
		{
			this.chain = chain;
			run = true;
		}
	}
	public <InputType, OutputType> void addChain(DataProvider<InputType, OutputType> dataProvider)
	{
		threads.add(new DataProviderThread(dataProvider));
	}
	public void addChains(List<DataProvider<?,?>> dataProviders)
	{
		for(DataProvider<?, ?> dataProvider : dataProviders)
		{
			threads.add(new DataProviderThread(dataProvider));
		}
	}
	public void startThreads()
	{
		for(DataProviderThread thread : threads)
		{
			thread.start();
		}
	}
	public void stopThreads()
	{
		for(DataProviderThread thread : threads)
		{
			thread.stopThread();
		}
	}
	@Override
	protected Void calculateData(DataProvider inputData)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
