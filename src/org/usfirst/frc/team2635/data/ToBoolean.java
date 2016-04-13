package org.usfirst.frc.team2635.data;

public class ToBoolean extends DataProvider<Double, Boolean>
{

	
	public ToBoolean()
	{
		super();
	}

	@Override
	protected Boolean calculateData(Double inputData)
	{
		return !(inputData == 0.0);
	}
	
}
