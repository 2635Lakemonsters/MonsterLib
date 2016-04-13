package org.usfirst.frc.team2635.data;

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
