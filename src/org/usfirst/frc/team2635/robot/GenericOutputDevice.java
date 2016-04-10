package org.usfirst.frc.team2635.robot;

public abstract class GenericOutputDevice<InputType>
{
	GenericInputProcessor<?, InputType> input;
	public void actuate()
	{
		actuateOnInput(input.process());
	}
	public abstract void actuateOnInput(InputType input);
}
