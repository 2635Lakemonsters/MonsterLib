package org.usfirst.frc.team2635.data.implementation;

import java.awt.MouseInfo;
import java.awt.Point;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

public class MousePositionProvider extends OutputOnlyDataProvider<Point>
{

	@Override
	protected Point calculateData(Void unused)
	{
		return MouseInfo.getPointerInfo().getLocation();
	}

}
