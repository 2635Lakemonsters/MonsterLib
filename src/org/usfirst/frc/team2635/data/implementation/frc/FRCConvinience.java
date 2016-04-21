package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.DataProviderRunMultiple;

/**
 * A convinience class that will produce chains that act like common robot components.
 * @author Tristan
 *
 */
public class FRCConvinience
{
	/**
	 * Create a chain that will act like a tank drive. rightInput and leftInput provide to the top of rightSide and leftSide respectively.
	 * rightInput will calculate, then leftInput.
	 * @param rightSide 
	 * @param leftSide
	 * @param rightInput
	 * @param leftInput
	 * @return
	 */
	public static DataProvider<Void, Void> tankDrive(DataProvider<Double, ?> rightSide, DataProvider<Double, ?> leftSide, DataProvider<?, Double> rightInput, DataProvider<?, Double> leftInput)
	{
		rightInput.providesToTop(rightSide);
		
		
		leftInput.providesToTop(leftSide);
		
		
		return new DataProvider<Void, Void>()
				{

					@Override
					protected Void calculateData(Void inputData)
					{
						rightSide.getData();
						leftSide.getData();
						return null;
					}
			
				};
	}
	/**
	 * Creates a chain of dataProviders, assuming that each one feeds the next one with input unchanged.
	 * @param motors
	 * @return
	 */
	@SafeVarargs
	public static DataProvider<Double, Double> motorChain(DataProvider<Double,Double> ... motors)
	{
		for(int i = 0; i < motors.length - 1; i++)
		{
			motors[i].providesTo(motors[i + 1]);
		}
		return motors[motors.length];
	}
	
}
