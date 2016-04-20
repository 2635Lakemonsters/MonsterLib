package org.usfirst.frc.team2635.data;

public class Parameter<Type>
{
    Type parameter;

	OutputOnlyDataProvider<Type> getter = new OutputOnlyDataProvider<Type>()
	{

		@Override
		protected Type calculateData(Void unused)
		{
			return parameter;
		}
		
	};
	DataProvider<Type, Type> setter = new DataProvider<Type, Type>()
	{

		@Override
		protected Type calculateData(Type inputData)
		{
			parameter = inputData;
			return inputData;
		}
	};
	
	public <DataProviderOutputType> DataProvider<Type, DataProviderOutputType> providesTo(DataProvider<Type, DataProviderOutputType> dataProvider)
	{
		dataProvider.setDataProvider(getter);
		return dataProvider;
	}
	public void isSetBy(DataProvider<?, Type> dataProvider)
	{
		setter.inputProvider = dataProvider;
	}
	public void isSetConstant(Type constant)
	{
		setter.inputProvider = new ConstantProvider<Type>(constant);	
	}
	public Type getParameter()
	{
		return getter.getData();
	}
}
