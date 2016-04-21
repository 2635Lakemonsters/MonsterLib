package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;
import org.usfirst.frc.team2635.data.implementation.MetadataMode;
import org.usfirst.frc.team2635.data.implementation.frc.FRC;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainChooser;
import org.usfirst.frc.team2635.data.implementation.frc.FRC.Alliance;
import org.usfirst.frc.team2635.data.implementation.frc.FRC.Mode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;

public abstract class MonsterRobot //extends RobotBase
{
	FRCChainChooser environment = new FRCChainChooser();
	public abstract void initEnvironment(FRCChainChooser robotEnvironment);
	DataProviderThread mainThread;
	//@Override
	public void startCompetition()
	{
		initEnvironment(environment);
		DataProvider<DataProvider[],DataProvider[]> mainChain = new ConstantProvider<Mode>(Mode.Teleop)
				.providesTo(environment)
				.providesTo(new DataProviderRunMultiple());
		
		mainThread = new DataProviderThread(mainChain);
		mainThread.start();
	}

}
