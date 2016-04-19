package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;

/**
 * 
 * @author Tristan
 *
 * @param <PrintType>
 */
public class SystemPrint<PrintType> extends DataProvider<PrintType,PrintType>
{

	@Override
	protected PrintType calculateData(PrintType inputData)
	{
		System.out.println(inputData);
		return inputData;
	}

}

