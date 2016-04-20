package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

import edu.wpi.first.wpilibj.CANTalon;

public class CANTalonProvider extends OutputOnlyDataProvider<CANTalon>
{
	static CANTalon talon;
	
	@Override
	protected CANTalon calculateData(Void unused)
	{
		// TODO Auto-generated method stub
		return null;
	}
	public CANTalonProvider(int channel)
	{
		talon = new CANTalon(channel);
	}
}
