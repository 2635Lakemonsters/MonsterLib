package org.usfirst.frc.team2635.data;

public class Parameter<Type> 
{
	boolean parameterIsConstant;
	OutputOnlyDataProvider<Type> parameterProvider = new OutputOnlyDataProvider<Type>()
	{

		@Override
		protected Type calculateData(Void unused)
		{
			return parameterGetter.getData();
		}
		
	};
	DataProvider<?, Type> parameterGetter;
	
	public <DataProviderOutputType> DataProvider<Type, DataProviderOutputType> providesTo(DataProvider<Type, DataProviderOutputType> dataProvider)
	{
		parameterProvider.providesTo(dataProvider);
		return dataProvider;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isConstant()
	{
		return parameterIsConstant;
	}
	/**
	 * Set the parameter to be a constant value. 
	 * @param constant The value that will be provided by parameter.
	 */
	public void setParameter(Type constant)
	{
		parameterIsConstant = true;
		parameterGetter = new ConstantProvider<Type>(constant);
	}
	/**
	 * Set the parameter to be calculated by a chain.
	 * @param dataProvider The provider at the bottom of the chain.
	 */
	public void setParameter(DataProvider<?, Type> dataProvider)
	{
		parameterIsConstant = false;
		parameterGetter = dataProvider;
	}
	/**
	 * Get the parameter through the parameterProvider.
	 * @return
	 */
	public Type getParameter()
	{
		return parameterProvider.getData();
	}



	
}
