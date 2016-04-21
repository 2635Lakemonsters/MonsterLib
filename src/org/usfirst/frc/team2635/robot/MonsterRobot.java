package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.DataProviderSetup;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainSelector;
import org.usfirst.frc.team2635.data.implementation.frc.FRC.Mode;

public abstract class MonsterRobot //extends RobotBase
{
	DataProviderSetup<FRCChainSelector> setup;
	public abstract void initEnvironment(FRCChainSelector robotEnvironment);
	DataProviderThread mainThread;
	//@Override
	public void startCompetition()
	{
		robotEnvironment
		DataProvider<DataProvider[],DataProvider[]> mainChain = 
				
				.providesTo(new DataProviderRunMultiple());
		
		mainThread = new DataProviderThread(mainChain);
		mainThread.start();
	}

}
