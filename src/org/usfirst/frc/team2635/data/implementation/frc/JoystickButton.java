package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

import edu.wpi.first.wpilibj.DriverStation;

public class JoystickButton extends OutputOnlyDataProvider<Boolean>
{
	DriverStation ds = DriverStation.getInstance();
	public Parameter<Integer> stickParameter = new Parameter<>();
	public Parameter<Integer> buttonParameter = new Parameter<>();
	@Override
	protected Boolean calculateData(Void unused)
	{
		int stick = stickParameter.get();
		int button = buttonParameter.get();
		
		
		return ds.getStickButton(stick, (byte) button);
	}
	public JoystickButton(UserSetup<JoystickButton> s)
	{
		s.setup(this);
	}
}
