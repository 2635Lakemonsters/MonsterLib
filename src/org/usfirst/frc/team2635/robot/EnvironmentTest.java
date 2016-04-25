package org.usfirst.frc.team2635.robot;import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.ConstantProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionY;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.robot.FRCMetadata.Alliance;
import org.usfirst.frc.team2635.robot.FRCMetadata.Mode;

public class EnvironmentTest
{

	public static void main(String[] args)
	{
		Environment env = new Environment(new ConstantProvider<FRCMetadata>(new FRCMetadata(Alliance.Blue, Mode.Teleop)));
		DataProvider<Double, Void> testChain = new MousePositionProvider()
				.providesTo(new MousePositionY())
				.providesTo(new SystemPrint<Double>());
		env.addTeleopChain(testChain);
		env.start();
	}

}
