package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.ParameterSetup;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.can.CANJNI;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;

public class CANTalonSetValue extends DataProvider<Double, Double>
{
	Parameter<Integer> channelParameter;
	int prevChannelReading;
	long handle;
	@Override
	protected Double calculateData(Double inputData)
	{
		if(!channelParameter.isConstant())
		{
			int currentChannelReading = channelParameter.getParameter();
			if(currentChannelReading != prevChannelReading)
			{
				CanTalonJNI.delete_CanTalonSRX(handle);
				handle = CanTalonJNI.new_CanTalonSRX(currentChannelReading);
			}
		}
		CanTalonJNI.Set(handle, inputData);
		return inputData;
	}
	public CANTalonSetValue(ParameterSetup<CANTalonSetValue> s)
	{
		s.setup(this);
		handle = CanTalonJNI.new_CanTalonSRX(channelParameter.getParameter());
	}
}
