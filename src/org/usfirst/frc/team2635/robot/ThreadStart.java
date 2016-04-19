package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.DataProvider;

public class ThreadStart extends DataProvider<DataProviderThread, DataProviderThread>
{

	@Override
	protected DataProviderThread calculateData(DataProviderThread inputData)
	{
		inputData.start();
		return inputData;
	}

}
