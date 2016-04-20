package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

import edu.wpi.first.wpilibj.CANTalon;

public class CANTalonChains
{
	public CANTalonChains(int channelNumber)
	{
		talon = new CANTalon(channelNumber);
	}
	protected static CANTalon talon;
	
	public static final OutputOnlyDataProvider<Double> speedProvider = new OutputOnlyDataProvider<Double>()
	{
		@Override
		protected Double calculateData(Void inputData) 
		{
			return talon.getSpeed();
		}

	};
	
	
}
