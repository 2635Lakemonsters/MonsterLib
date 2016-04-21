package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.ParameterSetup;

import edu.wpi.first.wpilibj.DriverStation;

public class FRC
{
	public enum Mode
	{
		Teleop,
		Auto,
		Test,
		Disabled
	}
	public enum Alliance
	{
		Red,
		Blue
	}
	Parameter<Alliance> alliance = new Parameter<>();
	Parameter<Mode> mode = new Parameter<>();
	
	public FRC(ParameterSetup<FRC> setup)
	{
		setup.setup(this);
	}
	
}
