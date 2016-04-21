package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;
import org.usfirst.frc.team2635.data.implementation.FRCChainChooser;
import org.usfirst.frc.team2635.data.implementation.MetadataMode;
import org.usfirst.frc.team2635.robot.FRC.Alliance;
import org.usfirst.frc.team2635.robot.FRC.Mode;

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
		DataProvider<DataProvider[],DataProvider[]> mainChain = new DataProviderRunMultiple();
		new FRC((FRC frc) -> 
		{
			frc.mode.setParameter(Mode.Teleop);
			
			frc.mode.providesTo(environment)
			.providesTo(mainChain);

			
			frc.alliance.setParameter(Alliance.Blue);
		});
				
		mainThread = new DataProviderThread(mainChain);
		mainThread.start();
	}

}
