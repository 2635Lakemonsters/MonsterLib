package org.usfirst.frc.team2635.robot;

import java.awt.Point;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.AddConstant;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointX;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;

public class MonsterRobotTest
{

	public static void main(String[] args)
	{
		//MonsterRobot should have its extends commented out and @Override commented
		//Should probably just redo BaseRobot entirely some day
		MonsterRobot monsterRobot = new MonsterRobot()
		{
			
			@Override
			public void initEnvironment(FRCChainChooser robotEnvironment)
			{
				DataProvider<Point, Double> dummyJoystick1 = 
						new MousePositionProvider()
						.providesTo(new PointY());
				DataProvider<Double, Double> dummyJoystick2 = 
						new MousePositionProvider()
						.providesTo(new PointX())
						.providesTo(new AddConstant(500.0)); //A simulation so advanced it has broken joysticks built in.
				DataProvider<Double, Double> dummyMotor1 = 
						new SystemPrint<Double>();
				
				DataProvider<Double, Double> dummyMotor2 = 
						new SystemPrint<Double>();
				
				dummyJoystick1.providesToReplacesTop(dummyMotor1);
				dummyJoystick2.providesToReplacesTop(dummyMotor2);
				robotEnvironment.addTeleopChain(dummyMotor1);
				robotEnvironment.addTeleopChain(dummyMotor2);
			}
		};
		monsterRobot.startCompetition();

	}

}
