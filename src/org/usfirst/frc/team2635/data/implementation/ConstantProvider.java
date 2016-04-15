package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

public class ConstantProvider<ConstantType> extends OutputOnlyDataProvider<ConstantType>
{
	
	ConstantType c;
	@Override
	protected ConstantType calculateData(Void unused)
	{
		// TODO Auto-generated method stub
		return c;
	}
	public ConstantProvider(ConstantType constant)
	{
		c = constant;
	}
}
