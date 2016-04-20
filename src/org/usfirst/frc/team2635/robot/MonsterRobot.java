package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.implementation.ConstantProvider;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;
import org.usfirst.frc.team2635.data.implementation.FRCChainChooser;
import org.usfirst.frc.team2635.data.implementation.MetadataMode;
import org.usfirst.frc.team2635.robot.FRCMetadata.Alliance;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

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
		//TODO: Make some intelligent way to choose how FRCMetadata is provided.
		DataProvider<DataProvider[],DataProvider[]> mainChain = 
				new ConstantProvider<FRCMetadata>(new FRCMetadata(Mode.Teleop, Alliance.Blue))
				.providesTo(new MetadataMode()) //TODO: Accessors overkill?
				.providesTo(environment)
				.providesTo(new DataProviderRunMultiple());
		mainThread = new DataProviderThread(mainChain);
		mainThread.start();
	}

}
