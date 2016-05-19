package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

public interface Encoder
{
	public class EncoderModel
	{
		public Parameter<Integer> aChannel;
		public Parameter<Integer> bChannel;
	}
	public OutputOnlyDataProvider<Double> encoderVelocity(UserSetup<EncoderModel> setup);
	public OutputOnlyDataProvider<Double> encoderPosition(UserSetup<EncoderModel> setup);
	
}
