package org.usfirst.frc.team2635.data;

/**
 * 
 * @author Tristan
 *
 * @param <PrintType>
 */
public class SystemPrint<PrintType> extends InputOnlyDataProvider<PrintType>
{

	@Override
	protected Void calculateData(PrintType inputData)
	{
		System.out.println(inputData);
		return null;
	}

}

