package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.Parameter;

public class DataProviderStorage<StorageType> extends DataProvider<StorageType, StorageType>
{
	public Parameter<StorageType> storageParameter = new Parameter<>();
	@Override
	protected StorageType calculateData(StorageType inputData)
	{
		storageParameter.set(inputData);
		return inputData;
	}

}
