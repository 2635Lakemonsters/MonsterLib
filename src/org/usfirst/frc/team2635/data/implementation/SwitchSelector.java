package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

public class SwitchSelector<OutputType> extends DataProvider<Boolean, OutputType>
{
	public Parameter<OutputType> trueChoice = new Parameter<>();
	public Parameter<OutputType> falseChoice = new Parameter<>();
	
	@Override
	protected OutputType calculateData(Boolean inputData)
	{
		if(inputData)
		{
			return trueChoice.get();
		}
		else
		{
			return falseChoice.get();
		}

	}
	public SwitchSelector(UserSetup<SwitchSelector<OutputType>> s)
	{
		s.setup(this);
	}

}
