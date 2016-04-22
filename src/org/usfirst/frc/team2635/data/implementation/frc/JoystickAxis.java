package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.DriverStation;

public class JoystickAxis extends OutputOnlyDataProvider<Double>
{
	DriverStation ds = DriverStation.getInstance();
	public Parameter<Integer> channelParameter = new Parameter<>();
	public Parameter<Integer> axisParameter = new Parameter<>();
	
	@Override
	protected Double calculateData(Void unused)
	{
		
		int channel = channelParameter.get();
		int axis = axisParameter.get();
		
		return ds.getStickAxis(channel, axis);
		
	}
	public JoystickAxis(UserSetup<JoystickAxis> s)
	{
		s.setup(this);
	}
}
