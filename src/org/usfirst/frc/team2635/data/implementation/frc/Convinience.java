package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;

public class Convinience
{
	//TODO: This could be a bit nicer.
	public static DataProvider<Void, Void> getTankDriveChain(DataProvider<Double, ?>[] rightSide, DataProvider<Double, ?>[] leftSide, DataProvider<?, Double> rightInput, DataProvider<?, Double> leftInput)
	{
		for(DataProvider<Double, ?> rightOutput : rightSide)
		{
			rightInput.providesToTop(rightOutput);
		}
		for(DataProvider<Double, ?> leftOutput : leftSide)
		{
			rightInput.providesToTop(leftOutput);
		}
		DataProvider<DataProvider[], DataProvider[]> rightRunner = new ConstantProvider<DataProvider[]>(rightSide).providesTo(new DataProviderRunMultiple());
		DataProvider<DataProvider[], DataProvider[]> leftRunner = new ConstantProvider<DataProvider[]>(leftSide).providesTo(new DataProviderRunMultiple());
		
		return new DataProvider<Void, Void>()
				{

					@Override
					protected Void calculateData(Void inputData)
					{
						rightRunner.getData();
						leftRunner.getData();
						return null;
					}
			
				};
	}
	
}
