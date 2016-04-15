package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

import edu.wpi.first.wpilibj.DriverStation;

public class DriverstationMetadata extends OutputOnlyDataProvider<FRCMetadata>
{

	DriverStation ds = DriverStation.getInstance();

	@Override
	protected FRCMetadata calculateData(Void unused)
	{
		FRCMetadata data = new FRCMetadata();
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
