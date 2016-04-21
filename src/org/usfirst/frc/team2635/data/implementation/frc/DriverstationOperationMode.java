package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.implementation.frc.FRC.Mode;

import edu.wpi.first.wpilibj.DriverStation;

public class DriverstationOperationMode extends OutputOnlyDataProvider<FRC.Mode>
{

	DriverStation ds = DriverStation.getInstance();

	@Override
	protected FRC.Mode calculateData(Void unused)
	{
		if(ds.isAutonomous())
		{
			return Mode.Auto;
		}
		else if(ds.isOperatorControl())
		{
			return Mode.Teleop;
		}
		else if(ds.isTest())
		{
			return Mode.Test;
		}
		else
		{
			return Mode.Disabled;
		}
	
	}

}
