package org.usfirst.frc.team2635.data;

public class LastOutputtedProvider<InputType, OutputType> extends DataProvider<DataProvider<InputType, OutputType>, OutputType>
{

	@Override
	protected OutputType calculateData(DataProvider<InputType, OutputType> inputData)
	{
		return inputData.getLastOutputted();
	}

}
