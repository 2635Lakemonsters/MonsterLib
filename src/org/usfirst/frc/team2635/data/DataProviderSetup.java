package org.usfirst.frc.team2635.data;

/**
 * The primary purpose of this class is to make inline initialization of a DataProvider easier to do.
 * An implementing class of DataProvider should provide this class as an argument and call setup on <code>this</code>.
 * @author tthompso
 *
 * @param <DataProviderType> The type of the DataProvider that needs to be initialized.
 */
public interface DataProviderSetup<DataProviderType> 
{
	/**
	 * Perform setup operations on the Parameters inside the DataProvider.
	 * @param dataProvider
	 */
	public void setup(DataProviderType dataProvider);
}
