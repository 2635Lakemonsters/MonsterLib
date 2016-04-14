package org.usfirst.frc.team2635.data;

/**
 * The basis for all data operations. If you want to create your own data without operating on existing data, 
 * you should extend off of {@link OutputOnlyDataProvider}. If you want to only accept data, 
 * extend off of {@link InputOnlyDataProvider}.
 * @author Tristan
 *
 * @param <InputType> Type of the input given to the provider.
 * @param <OutputType> Type of the output given by the provider.
 * 
 * @see OutputOnlyDataProvider
 * @see InputOnlyDataProvider
 */
public abstract class DataProvider<InputType, OutputType>
{
	DataProvider<?, InputType> inputProvider;
	/**
	 * Set what is providing the input to the DataProvider. It is preferable to use {@link providesTo}, because 
	 * it makes the code more compact and easier to follow. 
	 * @param inputProvider The DataProvider providing input.
	 */
	public void setDataProvider(DataProvider<?, InputType> inputProvider)
	{
		this.inputProvider = inputProvider;
	}
	
	/**
	 * An operation that occurs on the inputData. 
	 * @param inputData Data from the DataProvider's inputProvider
	 * @return inputData that has been processed.
	 */
	protected abstract OutputType calculateData(InputType inputData);

	/**
	 * This object will now provide its data to the argument {@code dataProvider}. This function returns
	 * dataProvider, to allow easy chaining of providesTos. For example: 
	 * <br>
	 * <br>
	 *<code>
	 *	DataProvider<Double, Double> a; <br>
	 *	DataProvider<Double, Integer> b; <br>
	 *	DataProvider<Integer, Float> c; <br>
	 *	a.providesTo(b).providesTo(c); <br>
	 *	//a will process first, pass its data to b, b will pass its data to c
	 *</code>
	 * 
	 * @param <DataProviderOutputType> The output type of the given DataProvider. Should be inferred by the compiler and is not required to be given.
	 * @param dataProvider The DataProvider that the calling object will give data to.
	 * @return A reference to dataProvider
	 */
	public <DataProviderOutputType> DataProvider<OutputType, DataProviderOutputType>  providesTo(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	{
		
		dataProvider.setDataProvider(this);
		return dataProvider;
	}
	/**
	 * Same thing as {@link providesTo}, but returns a reference to the current object. Allows the connection of chains to multiple objects.
	 * @param dataProvider The DataProvider that the calling object will give data to.
	 * @return A reference to the current object.
	 */
	public <DataProviderOutputType> DataProvider<InputType, OutputType>  providesToAnd(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	{
		dataProvider.setDataProvider(this);
		return this;
	}
	/**
	 * A shorthand for {@link providesToAnd} that allows a DataProvider to provide its chain to multiple other dataProviders.
	 * The nature of the arguments given means that the chain ends with this method.
	 * @param dataProviders
	 */
	@SuppressWarnings("unchecked") //Trust me, we'll be fine
	public void providesToMultiple(InputOnlyDataProvider<OutputType>... dataProviders)
	{
		for(InputOnlyDataProvider<OutputType> dataProvider : dataProviders)
		{
			dataProvider.setDataProvider(this);
		}
		
	}
	/**
	 * {@link providesTo}, but in reverse. {@code inputProvider} will now provide its data to this object.
	 * @param dataProvider The DataProvider that is giving data to the object
	 * @return A reference to dataProvider
	 */
	public <DataProviderInputType> DataProvider<DataProviderInputType, InputType> isProvidedToBy(DataProvider<DataProviderInputType, InputType> dataProvider)
	{
		setDataProvider(dataProvider);
		return dataProvider;
	}
	/**
	 * Goes to the top of the DataProvider chain and then runs calculateData for every object in that chain, such that the input of one
	 * data provider feeds into the next. For example, if A is a data provider for B, A will calculate data for B, and B will operate on A's data.
	 * @return Data that has been processed by every DataProcessor attached to this object.
	 */
	public OutputType getData()
	{	
		if(inputProvider != null)
		{
			//Request inputProvider's getData routine, which could call inputProvider's inputProvider's getData routine...
			return calculateData(inputProvider.getData()); 
		}
		//There are no more inputProviders, time to start calculating back down the stack.
		return calculateData(null);
	}
	public DataProvider()
	{
		super();
	}
	
	
}