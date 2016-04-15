package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.DataProviderExecutor;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

public class Environment extends Thread
{
	
	OutputOnlyDataProvider<FRCMetadata> frc;
	DataProviderExecutor autonomous;
	DataProviderExecutor teleop;
	DataProviderExecutor disabled;
	DataProviderExecutor test;
	DataProviderExecutor currentExecutor;
	public void addAutonomousChain(DataProvider<?, ?> chain)
	{
		autonomous.addChain(chain);
	}
	public void addTeleopChain(DataProvider<?, ?> chain)
	{
		teleop.addChain(chain);
	}
	public void addDisabledChain(DataProvider<?, ?> chain)
	{
		disabled.addChain(chain);
	}
	public void addTestChain(DataProvider<?, ?> chain)
	{
		test.addChain(chain);
	}
	@Override
	public void run()
	{
		//Assume we start disabled
		Mode previousMode = Mode.Disabled;
		currentExecutor.startThreads();
		while(true)
		{
			FRCMetadata frcState = frc.getData();
			Mode currentMode = frcState.getMode();
			if(previousMode != frcState.getMode())
			{
				currentExecutor.stopThreads();
				switch(currentMode)
				{
				case Auto:
					currentExecutor = autonomous;
					break;
				case Disabled:
					currentExecutor = disabled;
					break;
				case Teleop:
					currentExecutor = teleop;
					break;
				case Test:
					currentExecutor = test;
					break;
				default:
					//TODO: Throw some sort of error here
					break;
				
				}
				currentExecutor.startThreads();
			}
		}
	}
	public Environment(OutputOnlyDataProvider<FRCMetadata> frcProvider)
	{
		frc = frcProvider;
		autonomous = new DataProviderExecutor();
		teleop = new DataProviderExecutor();
		test = new DataProviderExecutor();
		disabled = new DataProviderExecutor();
		currentExecutor = disabled;
	}
}
