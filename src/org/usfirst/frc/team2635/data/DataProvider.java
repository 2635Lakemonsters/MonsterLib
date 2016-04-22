package org.usfirst.frc.team2635.data;

/**
 * The basis for all data operations. If you want to create your own data without operating on existing data, 
 * you should extend off of {@link OutputOnlyDataProvider}. Data that has no operations performed on it should 
 * be returned.
 * @author Tristan
 *
 * @param <InputType> Type of the input given to the provider.
 * @param <OutputType> Type of the output given by the provider.
 * 
 * @see OutputOnlyDataProvider
 */
public abstract class DataProvider<InputType, OutputType>
{
	DataProvider<?, InputType> inputProvider;
	OutputType outputtedData;
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
	 * Get what is providing the input to the DataProvider.
	 * @return What is providing the input to the DataProvider
	 */
	public DataProvider<?, InputType> getInputProvider()
	{
		return inputProvider;
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
	public <DataProviderOutputType> DataProvider<OutputType, DataProviderOutputType>  providesSelfTo(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	/**
	 * Signifies that the providing DataProvider provides to dataProvider as a top input. This has the effect of 
	 * removing dataProvider's OutputOnlyDataProvider and replacing it with the bottom of the providing DataProvider's chain.
	 * @param dataProvider The DataProvider that the calling object will give data to.
	 * @return A reference to dataProvider
	 */
	
	@SuppressWarnings("unchecked") // Checked enough
	public <DataProviderOutputType> DataProvider<OutputType, DataProviderOutputType> providesToReplacesTop(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	{
		DataProvider<OutputType, ?> oneBeforeOutputOnly = null;
		try
		{
			oneBeforeOutputOnly = (DataProvider<OutputType, ?>) dataProvider.getOneBeforeTop();
		}
		catch(ClassCastException ex)
		{
			System.err.println("Providing data provider's output type is incompatible with the input type of dataProvider's first non OutputOnlyDataProvider node.");
			ex.printStackTrace();
		}
		oneBeforeOutputOnly.setDataProvider(this);
		return dataProvider;
		
	}
	/**
	 * Goes to the top node of the chain, links the node to the providing DataProvider.
	 * @param dataProvider
	 * @return
	 */
	public <DataProviderOutputType> DataProvider<OutputType, DataProviderOutputType> providesToTop(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	{
		DataProvider<OutputType, ?> topNode = null;
		try 
		{
			topNode = (DataProvider<OutputType, ?>) dataProvider.getTop();
		}
		catch(ClassCastException ex)
		{
			//TODO: Add an error message
		}
		topNode.setDataProvider(this);
		return dataProvider;
	}
	//TODO: Might want to review naming with someone
	/**
	 * The bottom of a chain is commonly some output device, so if two chains need to be combined, it may be necessary to remove that output.
	 * This method uses the DataProvider above the output device as the input of dataProvider's first input receiving node.
	 * @param dataProvider
	 * @return
	 */
	public <DataProviderOutputType>  DataProvider<OutputType, DataProviderOutputType> providesToAsTopSkipsBottom(DataProvider<OutputType, DataProviderOutputType> dataProvider)
	{
		DataProvider<?, InputType> oneAboveThis = null;
		oneAboveThis = (DataProvider<?, InputType>) getOneBeforeBottom();
		
		DataProvider<InputType, ?> oneBeforeTop = null;
		try
		{
			oneBeforeTop = (DataProvider<InputType, ?>) dataProvider.getOneBeforeTop();
		}
		catch(ClassCastException ex)
		{
			System.err.println("The node above the providing DataProvider's node's OutputType is incompatible with the InputType of dataProvider's first reciving node.");
			ex.printStackTrace();
		}
		oneBeforeTop.inputProvider = oneAboveThis;
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
	public void providesToMultiple(DataProvider<OutputType,OutputType>... dataProviders)
	{
		for(DataProvider<OutputType,OutputType> dataProvider : dataProviders)
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
	 * Get the first DataProvider in the chain.
	 * @return The first DataProvider in the chain.
	 */
	public DataProvider<?, ?> getTop()
	{
		DataProvider<?, ?> currentProvider = this;
		while(currentProvider.inputProvider != null)
		{
			currentProvider = currentProvider.inputProvider;
		}
		return currentProvider;
	}
	/**
	 * Gets the DataProvider one up from the bottom.
	 * @return
	 */
	@SuppressWarnings("unchecked") //Based on how the chain is built, the cast should succeed.
	public DataProvider<?, InputType> getOneBeforeBottom()
	{
		return (DataProvider<?, InputType>) getProviderAt(1);
	}
	/**
	 * Gets the DataProvider one below the top. Also the first DataProvider that has both an input and an output.
	 * @return
	 */
	public DataProvider<?, ?> getOneBeforeTop()
	{
		int chainSize = getChainSize();
		if(chainSize > 1)
		{
			return getProviderAt(chainSize - 2);
		}
		else
		{
			return this;
		}
	}
	//TODO: Need to add robustness against looping chains.
	/**
	 * Returns the size of the chain, including the calling object. This has the effect of the size never being below 1.
	 * @return
	 */
	public int getChainSize()
	{
		int i = 1;
		DataProvider<?, ?> currentProvider = this;
		while(currentProvider.inputProvider != null)
		{
			currentProvider = currentProvider.inputProvider;
			i++;
		}
		return i;

	}
	//TODO: Throw error instead of highest index?
	/**
	 * Get the DataProvider at a certain index. If the index is above the size of the chain, the highest possible DataProvider is returned.
	 * @param index
	 * @return
	 */
	public DataProvider<?, ?> getProviderAt(int index)
	{
		int i = 0;
		DataProvider<?, ?> currentProvider = this;
		while(currentProvider.inputProvider != null && i < index)
		{
			currentProvider = currentProvider.inputProvider;
			i++;
		}
		return currentProvider;
	}
	public OutputType getLastOutputted()
	{
		return outputtedData;
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
			outputtedData = calculateData(inputProvider.getData()); 	
		}
		else 
		{
			//There are no more inputProviders, time to start calculating back down the stack.

			outputtedData = calculateData(null);
		}
	
		
		return outputtedData;
	}

	public DataProvider()
	{
		super();
	}
	

}