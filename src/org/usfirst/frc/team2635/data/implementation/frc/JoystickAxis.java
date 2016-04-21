package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.DataProviderSetup;

import edu.wpi.first.wpilibj.DriverStation;

public class JoystickAxis extends OutputOnlyDataProvider<Double>
{
	DriverStation ds = DriverStation.getInstance();
	Parameter<Integer> channelParameter;
	Parameter<Integer> axisParameter;
	int channel;
	int axis;
	@Override
	protected Double calculateData(Void unused)
	{
		
		channel = channelParameter.getParameter();
		axis = axisParameter.getParameter();
		
		return ds.getStickAxis(channel, axis);
		
	}
	public JoystickAxis(DataProviderSetup<JoystickAxis> s)
	{
		s.setup(this);
	}
}
