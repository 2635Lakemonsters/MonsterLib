package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;

public class CANTalonEncoderVelocity extends OutputOnlyDataProvider<Double>
{

	public Parameter<Integer> channelParameter = new Parameter<>();
	public Parameter<Long> handleParameter = new Parameter<>();
	public Parameter<FeedbackDevice> feedbackDeviceParameter = new Parameter<>(FeedbackDevice.QuadEncoder);
	int prevChannelReading = -1;
	
	@Override
	protected Double calculateData(Void unused)
	{
		int currentChannelReading = channelParameter.get();
		if(currentChannelReading != prevChannelReading)
		{
			CanTalonJNI.delete_CanTalonSRX(handleParameter.get());
			handleParameter.set(CanTalonJNI.new_CanTalonSRX(currentChannelReading));
		}
		return (double) CanTalonJNI.GetEncVel(handleParameter.get());
		
	}
	public CANTalonEncoderVelocity(UserSetup<CANTalonEncoderVelocity> s)
	{
		s.setup(this);
	}
}
