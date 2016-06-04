package org.usfirst.frc.team2635.data;

public abstract class DoubleProvider<InputType> extends DataProvider<InputType, Double>
{

	@Override
	protected abstract Double calculateData(InputType inputData);
	protected <DataProviderOutputType, OperatorInputType> DataProvider<Double, DataProviderOutputType> operationTo(DataProvider<Double, DataProviderOutputType> recipient, DataProvider<Double, Double> operator)
	{
		this.providesTo(operator).providesTo(recipient);
		return recipient;
	}
	public <DataProviderOutputType> DataProvider<Double, DataProviderOutputType> multipliesTo(DataProvider<Double, DataProviderOutputType> recipient, double multiplier)
	{
		return multipliesTo(recipient, new ConstantProvider<Double>(multiplier));
	}
	public <DataProviderOutputType, MultiplierInputType> DataProvider<Double, DataProviderOutputType> multipliesTo(DataProvider<Double, DataProviderOutputType> recipient, DataProvider<MultiplierInputType, Double> multiplier)
	{
		DataProvider<Double, Double> multiplicationProvider = new DataProvider<Double, Double>()
		{

			@Override
			protected Double calculateData(Double inputData)
			{
				return inputData * multiplier.getData();
			}
	
		};
		return operationTo(recipient, multiplicationProvider);
	}	
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> addsTo(DataProvider<Double, DataProviderOutputType> recipient, DataProvider<AdderInputType, Double> adder)
	{
		DataProvider<Double, Double> additionProvider = new DataProvider<Double, Double>()
		{

			@Override
			protected Double calculateData(Double inputData)
			{
				return inputData + adder.getData();
			}
			
		};
		return operationTo(recipient, additionProvider);
	}
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> addsTo(DataProvider<Double, DataProviderOutputType> recipient, double adder)
	{
		return addsTo(recipient, new ConstantProvider<Double>(adder));
	}
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> subtractsTo(DataProvider<Double, DataProviderOutputType> recipient, DataProvider<AdderInputType, Double> subtracter)
	{
		DataProvider<Double, Double> subtractionProvider = new DataProvider<Double, Double>()
		{

			@Override
			protected Double calculateData(Double inputData)
			{
				return inputData - subtracter.getData();
			}
			
		};
		return operationTo(recipient, subtractionProvider);
	}
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> subtractsTo(DataProvider<Double, DataProviderOutputType> recipient, double subtracter)
	{
		return subtractsTo(recipient, new ConstantProvider<Double>(subtracter));
	}
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> dividesTo(DataProvider<Double, DataProviderOutputType> recipient, DataProvider<AdderInputType, Double> divider)
	{
		DataProvider<Double, Double> dividerProvider = new DataProvider<Double, Double>() //Make this into a song
		{

			@Override
			protected Double calculateData(Double inputData)
			{
				return inputData - divider.getData();
			}
			
		};
		return operationTo(recipient, dividerProvider);
	}
	public <DataProviderOutputType, AdderInputType> DataProvider<Double, DataProviderOutputType> dividesTo(DataProvider<Double, DataProviderOutputType> recipient, double divider)
	{
		return dividesTo(recipient, new ConstantProvider<Double>(divider));
	}
}
