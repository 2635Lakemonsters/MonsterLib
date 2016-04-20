package org.usfirst.frc.team2635.data.implementation.multithread;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.robot.DataProviderThread;
public class ProviderAsThread extends DataProvider<DataProvider, DataProviderThread>
{


	@Override
	protected DataProviderThread calculateData(DataProvider inputData)
	{
		DataProviderThread thread = new DataProviderThread(inputData);
		return thread;
	}



}
