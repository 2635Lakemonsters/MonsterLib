package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.AddConstant;
import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.MousePositionProvider;
import org.usfirst.frc.team2635.data.MousePositionY;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.SubtractConstant;
import org.usfirst.frc.team2635.data.SystemPrint;

public class MathTestMain
{

	public static void main(String[] args)
	{
		//This is the end of the chain. getData() will go up the chain to the first OutputOnlyDataProvider, 
		//Have it provide data, and then go back down and process data
		DataProvider<Double, Void> chain; 
		//Setup the chain. The first chain element will provide data to the second element, the second will provide
		//Data to the third, and so on.
		chain = new ConstantProvider<Double>(3.0) //Start
			.providesTo(new SubtractConstant(1.0))
			.providesTo(new AddConstant(2.0))
			.providesTo(new SystemPrint<Double>()); //End
		
		chain.getData(); //Will print 4
		

	}

}
