package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.ParameterSetup;

/**
 * 
 * @author Tristan
 *
 * @param <PrintType>
 */
public class SystemPrint<PrintType> extends DataProvider<PrintType,PrintType>
{
	public Parameter<String> format = new Parameter<>();
	@Override
	protected PrintType calculateData(PrintType inputData)
	{
		System.out.format(format.getParameter(), inputData);
		return inputData;
	}
	public SystemPrint()
	{
		super();
		format.setParameter("%s%n");
	}
	public SystemPrint(ParameterSetup<SystemPrint<PrintType>> setupper)
	{
		setupper.setup(this);
	}
}

