package org.usfirst.frc.team2635.data;

import java.awt.Point;

public class MousePositionY extends DataProvider<Point, Double>
{

	@Override
	protected Double calculateData(Point inputData)
	{
		return inputData.getY();
	}

}
