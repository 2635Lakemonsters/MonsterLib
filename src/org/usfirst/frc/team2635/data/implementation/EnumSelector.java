package org.usfirst.frc.team2635.data.implementation;

import java.util.HashMap;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;

public class EnumSelector<EnumType extends Enum,OutputType> extends DataProvider<Enum, OutputType>
{

	Parameter<HashMap<Enum, DataProvider<?, OutputType>>> selectParameter;
	@Override
	protected OutputType calculateData(Enum inputData)
	{
		return null;
	}


}
