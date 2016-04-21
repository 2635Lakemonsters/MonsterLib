package org.usfirst.frc.team2635.data.implementation.math;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.DataProviderSetup;

public class ValueWithinRange extends DataProvider<Double, Boolean>
{
	Parameter<Double> lowerBoundParameter;
	Parameter<Double> upperBoundParameter;
	@Override
	protected Boolean calculateData(Double inputData)
	{
		double lowerBound = lowerBoundParameter.getParameter();
		double upperBound = upperBoundParameter.getParameter();
		
		return inputData >= lowerBound && inputData <= upperBound;
		
	}
	public ValueWithinRange(DataProviderSetup<ValueWithinRange> s)
	{
		s.setup(this);
	}

}
