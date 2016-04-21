package org.usfirst.frc.team2635.data.implementation;

import java.awt.Dimension;

import org.usfirst.frc.team2635.data.DataProvider;

public class DimensionHeight extends DataProvider<Dimension, Double>
{

	@Override
	protected Double calculateData(Dimension inputData)
	{
		return inputData.getHeight();
	}

}
