package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.DataProvider;

@SuppressWarnings("rawtypes") // We don't care what type the providers are.
public class DataProviderRunMultiple extends DataProvider<DataProvider[], DataProvider[]>
{

	@Override
	protected DataProvider[] calculateData(DataProvider[] inputData)
	{
		for(DataProvider provider : inputData)
		{
			provider.getData();
		}
		return inputData;
	}

}
