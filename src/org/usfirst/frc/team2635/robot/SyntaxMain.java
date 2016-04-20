package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.math.AddConstant;

public class SyntaxMain
{

	public static void main(String[] args)
	{
		SystemPrint<Double> printerProvidesTo = new SystemPrint<>();
		SystemPrint<Double> printerProvidedToBy = new SystemPrint<>();
		SystemPrint<Double> printer = new SystemPrint<>();
		SystemPrint<Double> printer2 = new SystemPrint<>();
		SystemPrint<Double> printer3 = new SystemPrint<>();
		//One way to define who provides to who is to start from the top down, with the OutputOnlyDataProvider starting the chain.
		new ConstantProvider<Double>(3.0).providesTo(new AddConstant(1.0)).providesTo(printerProvidesTo);
		
		//Another way is the bottom up, with the last object in the chain coming first.
		printerProvidedToBy.isProvidedToBy(new AddConstant(1.0)).isProvidedToBy(new ConstantProvider<Double>(3.0));
		
	
		//printer2 is provided to by AddConstant, who in turn is provided to by ConstantProvider, who separately provides to printer
		printer2.isProvidedToBy(new AddConstant(1.0))
			.isProvidedToBy(new ConstantProvider<Double>(3.0)).providesToAnd(printer).providesTo(printer3);
		
		printer2.getData();
		printer.getData();
		printer3.getData();
	}

}
