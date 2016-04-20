package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.robot.FRCMetadata;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

public class MetadataMode extends DataProvider<FRCMetadata, FRCMetadata.Mode>
{

	@Override
	protected Mode calculateData(FRCMetadata inputData)
	{
		return inputData.mode;
	}

}
