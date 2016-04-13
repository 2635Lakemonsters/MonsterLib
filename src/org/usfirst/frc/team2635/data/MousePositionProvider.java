package org.usfirst.frc.team2635.data;

import java.awt.MouseInfo;
import java.awt.Point;

public class MousePositionProvider extends OutputOnlyDataProvider<Point>
{

	@Override
	protected Point calculateData(Void unused)
	{
		return MouseInfo.getPointerInfo().getLocation();
	}

}
