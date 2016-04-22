package org.usfirst.frc.team2635.robot;

import java.awt.Point;

import org.usfirst.frc.team2635.data.ConstantProvider;
import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.implementation.MousePositionProvider;
import org.usfirst.frc.team2635.data.implementation.PointX;
import org.usfirst.frc.team2635.data.implementation.PointY;
import org.usfirst.frc.team2635.data.implementation.SwitchSelector;
import org.usfirst.frc.team2635.data.implementation.SystemPrint;
import org.usfirst.frc.team2635.data.implementation.frc.CANTalonSetValue;
import org.usfirst.frc.team2635.data.implementation.frc.FRCChainSelector;
import org.usfirst.frc.team2635.data.implementation.frc.FRCConvinience;
import org.usfirst.frc.team2635.data.implementation.frc.JoystickAxis;
import org.usfirst.frc.team2635.data.implementation.frc.JoystickButton;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation;
import org.usfirst.frc.team2635.data.implementation.math.MathOperation.Operation;

public class MonsterRobotTest
{

	public static void main(String[] args)
	{
		MonsterRobot monsterRobot = new MonsterRobot()
		{
			
			@Override
			public void initEnvironment(FRCChainSelector robotEnvironment)
			{
				
				
				DataProvider<Double, Double> leftDrive = new JoystickAxis((JoystickAxis j) ->
				{
					j.axisParameter.set(1);
					j.channelParameter.set(0);
				})
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(1)))
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(2)))
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(3)));
				
				DataProvider<Double, Double> rightDrive = new JoystickAxis((JoystickAxis j) ->
				{
					j.axisParameter.set(1);
					j.channelParameter.set(1);
				})
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(4)))
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(5)))
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(6)));
				
				//Generic dataflow for sending output to the flywheels.
				DataProvider<Double, Double> flywheelOutput =
				new CANTalonSetValue((c) -> c.channelParameter.set(7))
				.providesTo(new MathOperation((m) -> m.operationParameter.set(Operation.Negate)))
				.providesTo(new CANTalonSetValue((c) -> c.channelParameter.set(8)));
	
				DataProvider<Double,Double> flywheelForward = new JoystickButton((JoystickButton j) ->
				{
					j.buttonParameter.set(0);
					j.stickParameter.set(1);
				})
				.providesTo(new SwitchSelector<Double>((s) -> 
				{
					s.falseChoice.set(0.0);
					s.trueChoice.set(1.0); 
				}))
				.providesToTop(flywheelOutput);
				
				DataProvider<Double,Double> flywheelReverse = new JoystickButton((JoystickButton j) ->
				{
					j.buttonParameter.set(1);
					j.stickParameter.set(1);
				})
				.providesTo(new SwitchSelector<Double>((s) -> 
				{
					s.falseChoice.set(0.0);
					s.trueChoice.set(-1.0); 
				}))
				.providesToTop(flywheelOutput);
				
			}
		};
		monsterRobot.startCompetition();

	}

}
