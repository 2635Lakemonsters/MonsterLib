package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation.Operation;

public class MathTestMain
{

	public static void main(String[] args)
	{
		DataProvider<Double, Double> mainChain = new ConstantProvider<Double>(3.0)
				.providesTo
				(
						new MathOperation()
						//TODO: return upper class.
							.constantParameter.isSetBy( new ConstantProvider<Double>(3.0) )
							
				)
				.providesTo(new SystemPrint<Double>());
		mainChain.getData();
		

	}

}
