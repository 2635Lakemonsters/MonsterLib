package org.usfirst.frc.team2635.robot;

public abstract class GenericInputProcessor<InputType, OutputType>
{
	public GenericInputDevice<InputType> getInputDevice()
	{
		return inputDevice;
	}
	public void setInputDevice(GenericInputDevice<InputType> inputDevice)
	{
		this.inputDevice = inputDevice;
	}
	GenericInputDevice<InputType> inputDevice;
	public OutputType process()
	{
		return processInput(inputDevice.getInput());
	}
	protected abstract OutputType processInput(InputType input);
	
}
