package org.usfirst.frc.team2635.data;

public class DataStorage<DataType> extends DataProvider<DataType, DataType>
{
	public final Parameter<DataType> dataParameter = new Parameter<>();

	@Override
	protected DataType calculateData(DataType inputData)
	{
		dataParameter.set(inputData);
		return inputData;
	}
	
}
