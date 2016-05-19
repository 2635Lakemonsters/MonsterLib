package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public interface CANTalon
{
	class CANTalonModel
	{
		public Parameter<Integer> channelParameter = new Parameter<>();
		public Parameter<TalonControlMode> modeParameter = new Parameter<>(TalonControlMode.PercentVbus); 
		public Parameter<Double> PParameter = new Parameter<>(0.0);
		public Parameter<Double> IParameter = new Parameter<>(0.0);
		public Parameter<Double> DParameter = new Parameter<>(0.0);
	}
	class CANTalonEncoderModel
	{
		public Parameter<Integer> channelParameter = new Parameter<>();
		public Parameter<FeedbackDevice> feedbackDevice;
	}
	DataProvider<Double, Double> setCANTalon(UserSetup<CANTalonModel> setup);
	OutputOnlyDataProvider<Double> CANTalonEncoderPosition(UserSetup<CANTalonEncoderModel> setup);
	OutputOnlyDataProvider<Double> CANTalonEncoderVelocity(UserSetup<CANTalonEncoderModel> setup);
	
}
