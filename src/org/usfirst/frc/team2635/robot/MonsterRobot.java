package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.UserSetup;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainSelector;

import edu.wpi.first.wpilibj.RobotBase;

import org.usfirst.frc.team2635.data.implementation.frc.FRC.Mode;


public abstract class MonsterRobot extends RobotRoutine
{
	FRCChainChooser 
	public abstract void initEnvironment();
	DataProviderThread mainThread;
	@Override
	public void runRoutine()
	{
		
	}

}
