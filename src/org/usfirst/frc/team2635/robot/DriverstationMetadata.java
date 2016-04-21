package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.robot.FRC.Mode;

import edu.wpi.first.wpilibj.DriverStation;

public class DriverstationMetadata extends OutputOnlyDataProvider<FRC>
{

	DriverStation ds = DriverStation.getInstance();

	@Override
	protected FRC calculateData(Void unused)
	{
		FRC data = new FRC();
		boolean isAuto = ds.isAutonomous();
		boolean isTele = ds.isOperatorControl();
		boolean isTest = ds.isTest();
		
		if(isAuto)
		{
			data.setMode(Mode.Auto);
		}
		else if(isTele)
		{
			data.setMode(Mode.Teleop);
		}
		else if(isTest)
		{
			data.setMode(Mode.Test);
		}
		else
		{
			data.setMode(Mode.Disabled);
		}
		return data;
	}

}
