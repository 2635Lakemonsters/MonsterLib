package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.can.CANJNI;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;

public class CANTalonValueSetter extends DataProvider<Double, Double>
{
	public Parameter<Integer> channelParameter = new Parameter<>();
	public Parameter<TalonControlMode> modeParameter = new Parameter<>(TalonControlMode.PercentVbus); 
	public Parameter<Double> PParameter = new Parameter<>(0.0);
	public Parameter<Double> IParameter = new Parameter<>(0.0);
	public Parameter<Double> DParameter = new Parameter<>(0.0);
	
	int prevChannelReading;
	TalonControlMode prevModeReading = TalonControlMode.PercentVbus;
	public Parameter<Long> handle = new Parameter<Long>();
	//TODO: implement the rest of the control modes.
	@Override
	protected Double calculateData(Double inputData)
	{
		//Prevent from there being too much faddling with deleting and reiniting a CANTalon every tick.
		int currentChannelReading = channelParameter.get();
		if(currentChannelReading != prevChannelReading)
		{
			CanTalonJNI.delete_CanTalonSRX(handle.get());
			handle.set(CanTalonJNI.new_CanTalonSRX(currentChannelReading));
		}
		
		switch(mode)
		{
		case Current:
			break;
		case Follower:
			break;
		case PercentVbus:
			CanTalonJNI.Set(handle.get(), inputData);
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
		TalonControlMode mode = modeParameter.get();
		if(prevModeReading != mode)
		{
			
		}
	}
	public CANTalonValueSetter(UserSetup<CANTalonValueSetter> s)
	{
		s.setup(this);
		handle.set(CanTalonJNI.new_CanTalonSRX(channelParameter.get()));
		prevChannelReading = channelParameter.get();
	}
}
