package org.usfirst.frc.team2635.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FRCMetadata
{
	enum Mode
	{
		Teleop,
		Auto,
		Test,
		Disabled
	}
	enum Alliance
	{
		Red,
		Blue
	}
	Alliance alliance;
	Mode mode;
	
	public Mode getMode()
	{
		return mode;
	}
	public void setMode(Mode mode)
	{
		this.mode = mode;
	}
	
	public Alliance getAlliance()
	{
		return alliance;
	}
	public void setAlliance(Alliance alliance)
	{
		this.alliance = alliance;
	}
	public FRCMetadata(Mode mode, Alliance alliance)
	{
		this.mode = mode;
		this.alliance = alliance;
	}
}
