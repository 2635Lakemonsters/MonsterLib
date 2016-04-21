package org.usfirst.frc.team2635.data.implementation;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

public class ScreenDimension extends OutputOnlyDataProvider<Dimension>
{

	@Override
	protected Dimension calculateData(Void unused)
	{	
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
}
