package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;

public class SubtractConstant extends DataProvider<Double, Double>
{
	double c;
	public SubtractConstant(double constant)
	{
		super();
		this.c = constant;
	}
	@Override
	protected Double calculateData(Double inputData)
	{
		return inputData - c;
	}

}
