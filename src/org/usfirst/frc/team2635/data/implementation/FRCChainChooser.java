package org.usfirst.frc.team2635.data.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.DataProviderExecutor;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.robot.FRCMetadata;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

@SuppressWarnings("rawtypes")//We don't care about what type the dataprovider is.
public class FRCChainChooser extends DataProvider<FRCMetadata.Mode, DataProvider[]>
{
	
	ArrayList<DataProvider> autonomous;
	ArrayList<DataProvider> teleop;
	ArrayList<DataProvider> disabled;
	ArrayList<DataProvider> test;
	public void addAutonomousChain(DataProvider<?, ?> chain)
	{
		autonomous.add(chain);
	}
	public void addTeleopChain(DataProvider<?, ?> chain)
	{
		teleop.add(chain);
	}
	public void addDisabledChain(DataProvider<?, ?> chain)
	{
		disabled.add(chain);
	}
	public void addTestChain(DataProvider<?, ?> chain)
	{
		test.add(chain);
	}

	public FRCChainChooser()
	{
		autonomous = new ArrayList<>();
		teleop = new ArrayList<>();
		disabled = new ArrayList<>();
		test = new ArrayList<>();
	}
	
	@Override
	protected DataProvider[] calculateData(FRCMetadata.Mode gameMode)
	{
		switch(gameMode)
		{
		case Auto:
			return autonomous.toArray(new DataProvider[]{});
		case Disabled:
			return disabled.toArray(new DataProvider[]{});
		case Teleop:
			return teleop.toArray(new DataProvider[]{});
		case Test:
			return test.toArray(new DataProvider[]{});
		default:
			break;
		
		}
		return null;
	}
}
