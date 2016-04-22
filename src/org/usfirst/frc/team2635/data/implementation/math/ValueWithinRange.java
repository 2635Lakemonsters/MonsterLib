package org.usfirst.frc.team2635.data.implementation.math;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.UserSetup;

public class ValueWithinRange extends DataProvider<Double, Boolean>
{
	Parameter<Double> lowerBoundParameter;
	Parameter<Double> upperBoundParameter;
	@Override
	protected Boolean calculateData(Double inputData)
	{
		double lowerBound = lowerBoundParameter.get();
		double upperBound = upperBoundParameter.get();
		
		return inputData >= lowerBound && inputData <= upperBound;
		
	}
	public ValueWithinRange(UserSetup<ValueWithinRange> s)
	{
		s.setup(this);
	}

}
