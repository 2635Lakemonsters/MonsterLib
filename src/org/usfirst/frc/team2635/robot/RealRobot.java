package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.RobotBase;

public class RealRobot extends RobotBase
{
	RobotRoutine routine;

	@Override
	public void startCompetition()
	{
		routine.runRoutine();
	}
	public RealRobot(UserSetup<RealRobot> s)
	{
		s.setup(this);
	}
}
