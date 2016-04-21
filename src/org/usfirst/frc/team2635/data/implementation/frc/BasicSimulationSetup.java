package org.usfirst.frc.team2635.data.implementation.frc;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProviderSetup;
import org.usfirst.frc.team2635.data.implementation.frc.FRC.Mode;

public class BasicSimulationSetup extends FRCSetup
{

	@Override
	public void setup(FRCChainSelector dataProvider)
	{
		dataProvider.setDataProvider(new ConstantProvider<FRC.Mode>(Mode.Teleop));
		
	}

}
