package org.usfirst.frc.team2635.robot;

import java.util.List;

import org.usfirst.frc.team2635.data.DataSubscriber;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;

public abstract class MonsterRobot extends RobotBase
{
	DriverStation ds;
	List<DataSubscriber<?>> enabledSubscribers;
	List<DataSubscriber<?>> disabledSubscribers;
	List<DataSubscriber<?>> alwaysSubscribers;
	public abstract void initSubscribers();
	public abstract void initSubscribersAutonomous();
	public abstract void initSubscribersTeleop();
	public void addSubscriberRunEnabled(DataSubscriber<?> subscriber)
	{
		enabledSubscribers.add(subscriber);
	}
	public void addSubscriberRunDisabled(DataSubscriber<?> subscriber)
	{
		disabledSubscribers.add(subscriber);
	}
	public void addSubscriberRunAlways(DataSubscriber<?> subscriber)
	{
		alwaysSubscribers.add(subscriber);
	}
	
	@Override
	public void startCompetition()
	{
		initSubscribers();
		while(true)
		{
			if(ds.isEnabled() )
			{
				
			}
		}
	}

}
