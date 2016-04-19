package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;

public class DataProviderSwitch<InputType, OutputType> extends DataProvider<Boolean, DataProvider<InputType,OutputType>>
{
	DataProvider<InputType, OutputType> trueChoice;
	DataProvider<InputType, OutputType> falseChoice;

	@Override
	protected DataProvider<InputType, OutputType> calculateData(Boolean inputData)
	{
		if(inputData)
		{
			return trueChoice;
		}
		else
		{
			return falseChoice;
		}

	}

}
