package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;

public class DivideConstant extends DataProvider<Double, Double>
{
	double c;
	@Override
	protected Double calculateData(Double inputData)
	{
		return inputData/c;
	}
	public DivideConstant(double c)
	{
		this.c = c;
	}

}
