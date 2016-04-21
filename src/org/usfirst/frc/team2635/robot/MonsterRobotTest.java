package org.usfirst.frc.team2635.robot;

import java.awt.Point;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointX;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainSelector;
import org.usfirst.frc.team2635.data.implementation.frc.FRCConvinience;

public class MonsterRobotTest
{

	public static void main(String[] args)
	{
		//MonsterRobot should have its extends commented out and @Override commented
		//Should probably just redo BaseRobot entirely some day
		MonsterRobot monsterRobot = new MonsterRobot()
		{
			
			@Override
			public void initEnvironment(FRCChainSelector robotEnvironment)
			{
				
				DataProvider<Point, Double> dummyJoystick1 =
						new MousePositionProvider()
						.providesTo(new PointY());
				DataProvider<Point, Double> dummyJoystick2 = 
						new MousePositionProvider()
						.providesTo(new PointX());
				
				DataProvider<Double, Double> dummyMotor1 = 
						new SystemPrint<Double>((SystemPrint<Double> p) ->
						{
							p.format.setParameter("Dummy 1: %s%n");
						});
				
				DataProvider<Double, Double> dummyMotor2 = 
						new SystemPrint<Double>((SystemPrint<Double> p) ->
						{
							p.format.setParameter("Dummy 2: %s%n");
						});
				
				DataProvider<Void, Void> tankDrive = FRCConvinience.tankDrive(dummyMotor1, dummyMotor2, dummyJoystick1, dummyJoystick2);
				
				robotEnvironment.addTeleopChain(tankDrive);
			
			}
		};
		monsterRobot.startCompetition();

	}

}
