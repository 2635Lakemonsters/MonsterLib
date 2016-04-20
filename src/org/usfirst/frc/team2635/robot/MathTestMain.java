package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.implementation.AddConstant;
import org.usfirst.frc.team2635.data.implementation.ConstantProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SubtractConstant;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;

public class MathTestMain
{

	public static void main(String[] args)
	{
		DataProvider<Double, Double> chain; 
		DataProvider<Double, Double> secondChain;
		
		chain = new ConstantProvider<Double>(3.0) //Start
			.providesTo(new SubtractConstant(1.0))
			.providesTo(new AddConstant(2.0))
			.providesTo(new SystemPrint<Double>()); //End
		
		secondChain = new ConstantProvider<Double>(2.0)
			.providesTo(new AddConstant(57))
			.providesTo(new SystemPrint<Double>());
		DataProvider<Double, Double> thirdChain = chain.providesToReplacesTop(chain);		
		thirdChain.getData(); 
		

	}

}
