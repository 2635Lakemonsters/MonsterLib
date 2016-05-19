package org.usfirst.frc.team2635.robot;

import java.awt.Point;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.LastOutputtedProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation.Operation;

public class MathTestMain
{

	public static void main(String[] args)
	{
		DataProvider<Point, Double> mouseChain = new MousePositionProvider().providesTo(new PointY());
		
		DataProvider<Double, Double> mainChain = new ConstantProvider<Double>(3.0)
				.providesTo
				(
						new MathOperation((MathOperation m) ->
						{ 
							m.constantParameter.set(mouseChain);
							m.operationParameter.set(Operation.Add);
						})
				).providesTo(
						new SystemPrint<Double>((SystemPrint<Double> s) ->
						{
							s.format.set("Mouse position plus 3: %s%n");
						})
				);
		while(true)
		{
			mainChain.getData();
		}

	}

}
