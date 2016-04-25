package org.usfirst.frc.team2635.robot;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

public class SimulatedMetadata extends OutputOnlyDataProvider<FRCMetadata>
{

	@Override
	protected FRCMetadata calculateData(Void unused)
	{
		FRCMetadata data = new FRCMetadata();
		return null;
	}

}
