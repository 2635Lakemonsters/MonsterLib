package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;


public interface FRCProvider 
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
	
	
	CANTalon CANTalon();
	Joystick joystick();
	Encoder encoder();
	
	OutputOnlyDataProvider<Mode> getMode();
	OutputOnlyDataProvider<Alliance> getAlliance();
	
	
}
