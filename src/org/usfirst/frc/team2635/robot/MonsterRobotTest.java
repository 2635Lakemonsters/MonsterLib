package org.usfirst.frc.team2635.robot;

import java.awt.Point;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.CANTalonProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointX;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainChooser;

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
				
						
				DataProvider<Point, Double> dummyJoystick2 = 
						new MousePositionProvider()
						.providesTo(new PointX());
				
				DataProvider<Double, Double> dummyMotor1 = 
						new SystemPrint<Double>();
				
				DataProvider<Double, Double> dummyMotor2 = 
						new SystemPrint<Double>();
				
				dummyJoystick2.providesToTop(dummyMotor2);
				robotEnvironment.addTeleopChain(dummyMotor2);
			}
		};
		monsterRobot.startCompetition();

	}

}
