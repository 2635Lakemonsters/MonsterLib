package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.DataProviderSetup;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.can.CANJNI;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;

public class CANTalonSetValue extends DataProvider<Double, Double>
{
	Parameter<Integer> channelParameter;
	Parameter<TalonControlMode> modeParameter; 
	Parameter<Double> PParameter;
	Parameter<Double> IParameter;
	Parameter<Double> DParameter;
	int prevChannelReading;
	long handle;
	@Override
	protected Double calculateData(Double inputData)
	{
		//Prevent from there being too much faddling with deleting and reiniting a CANTalon every tick.
		int currentChannelReading = channelParameter.getParameter();
		if(currentChannelReading != prevChannelReading)
		{
			CanTalonJNI.delete_CanTalonSRX(handle);
			handle = CanTalonJNI.new_CanTalonSRX(currentChannelReading);
		}
		TalonControlMode mode = modeParameter.getParameter();
		
		switch(mode)
		{
		case Current:
			break;
		case Follower:
			break;
		case PercentVbus:
			CanTalonJNI.Set(handle, inputData);
			break;
		case Position:
			break;
		case Speed:
			break;
		case Voltage:
			break;
		default:
			break;
		}
		return inputData;
	}
	public CANTalonSetValue(DataProviderSetup<CANTalonSetValue> s)
	{
		s.setup(this);
		handle = CanTalonJNI.new_CanTalonSRX(channelParameter.getParameter());
	}
}
