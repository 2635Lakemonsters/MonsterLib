package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.DataProvider;

public class ThreadStop extends DataProvider<DataProviderThread, DataProviderThread>
{

	@Override
	protected DataProviderThread calculateData(DataProviderThread inputData)
	{
		inputData.stopThread();
		return inputData;
	}

}
