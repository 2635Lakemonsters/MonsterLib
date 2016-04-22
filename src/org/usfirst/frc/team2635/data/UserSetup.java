package org.usfirst.frc.team2635.data;

/**
 * The primary purpose of this class is to make inline custom initialization of easier to do.
 * Class should provide this class as an argument and call setup on <code>this</code>.
 * @author tthompso
 *
 * @param <ObjectType> The type of the object that needs to be initialized.
 */
public interface UserSetup<ObjectType> 
{
	/**
	 * Perform setup operations on the Parameters inside the DataProvider.
	 * @param dataProvider
	 */
	public void setup(ObjectType dataProvider);
}
