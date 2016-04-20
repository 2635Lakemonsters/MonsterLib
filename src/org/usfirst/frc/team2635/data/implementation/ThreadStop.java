package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.robot.DataProviderThread;

public class ThreadStop extends DataProvider<DataProviderThread, DataProviderThread>
{

	@Override
	protected DataProviderThread calculateData(DataProviderThread inputData)
	{
		inputData.stopThread();
		return inputData;
	}

}
