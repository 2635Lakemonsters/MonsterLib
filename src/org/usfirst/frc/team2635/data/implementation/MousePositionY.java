package org.usfirst.frc.team2635.data.implementation;

import java.awt.Point;

import org.usfirst.frc.team2635.data.DataProvider;

public class MousePositionY extends DataProvider<Point, Double>
{

	@Override
	protected Double calculateData(Point inputData)
	{
		return inputData.getY();
	}

}
