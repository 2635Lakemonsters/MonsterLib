package org.usfirst.frc.team2635.data;

/**
 * Represents the end of a DataProvider chain. Will only accept data, and will not return any meaningful data. 
 
 * @author Tristan
 *
 * @param <InputType> Type of the inputted data.
 */
public abstract class InputOnlyDataProvider<InputType> extends DataProvider<InputType, Void>
{

	/**
	 * Returns null. InputOnlyDataProvider gives a void object, and is not suitable for further processing.
	 */
	@Override
	public <DataProviderOutputType> DataProvider<Void,DataProviderOutputType> providesTo(DataProvider<Void,DataProviderOutputType> dataProvider) 
	{
		return null;
	}
	
	/**
	 * inputData should be operated on, but null should be returned.
	 */
	@Override
	protected abstract Void calculateData(InputType inputData);

}
