package org.usfirst.frc.team2635.data;

/**
 * 
 * @author Tristan
 *
 * @param <PrintType>
 */
public class SystemPrint<PrintType> extends DataProvider<PrintType, PrintType>
{

	@Override
	protected PrintType calculateData(PrintType inputData)
	{
		System.out.println(inputData);
		return inputData;
	}

}

