package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

public interface Joystick
{
	public class JoystickModel
	{
		public Parameter<Integer> channelParameter;
		public Parameter<Integer> indexParameter;
	}
	public OutputOnlyDataProvider<Double> getAxis(UserSetup<JoystickModel> setup);
	public OutputOnlyDataProvider<Boolean> getButton(UserSetup<JoystickModel> setup);
	public OutputOnlyDataProvider<Integer> getPOV(UserSetup<JoystickModel> setup);
}
