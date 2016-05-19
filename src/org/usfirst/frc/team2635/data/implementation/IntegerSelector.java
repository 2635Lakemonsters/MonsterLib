package org.usfirst.frc.team2635.data.implementation;

import java.util.HashMap;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

public class IntegerSelector<OutputType> extends DataProvider<Integer, OutputType>
{

	public HashMap<Integer, DataProvider<?, OutputType>> dataProviders;
	@Override
	protected OutputType calculateData(Integer inputData) throws IllegalArgumentException
	{
		if(!dataProviders.containsKey(inputData))
		{
			throw new IllegalArgumentException(inputData + " is an invalid index.");
		}
		return dataProviders.get(inputData).getData();
	}
	
	public IntegerSelector(UserSetup<IntegerSelector<OutputType>> s)
	{
		s.setup(this);
	}
}
