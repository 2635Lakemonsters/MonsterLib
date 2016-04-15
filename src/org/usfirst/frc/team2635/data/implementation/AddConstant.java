package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;

public class AddConstant extends DataProvider<Double, Double>
{
	double c;
	public AddConstant(double c)
	{
		super();
		this.c = c;
	}
	@Override
	protected Double calculateData(Double inputData)
	{
		return inputData + c;
	}
	
}
