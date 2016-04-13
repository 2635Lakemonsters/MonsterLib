package org.usfirst.frc.team2635.data;

/**
 * Represents the start of a DataProvider chain. Data begins here.
 * @author Tristan
 *
 * @param <OutputType> Type of the outputted data.
 */
public abstract class OutputOnlyDataProvider<OutputType> extends DataProvider<Void, OutputType>
{

	/**
	 * Create data for the chain. 
	 */
	@Override
	protected abstract OutputType calculateData(Void unused);
	

}
