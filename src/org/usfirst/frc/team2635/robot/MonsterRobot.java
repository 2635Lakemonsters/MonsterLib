package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;

public abstract class MonsterRobot extends RobotBase
{
	Environment environment;
	public abstract void initEnvironment(Environment robotEnvironment);
	
	@Override
	public void startCompetition()
	{
		environment = new Environment();
		initEnvironment(environment);
		environment.start();
	}

}
