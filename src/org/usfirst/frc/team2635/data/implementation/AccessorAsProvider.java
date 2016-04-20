package org.usfirst.frc.team2635.data.implementation;

import java.lang.reflect.Method;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccessorAsProvider<T> extends OutputOnlyDataProvider<T>
{
	Method accessor;
	@Override
	protected T calculateData(Void unused) {
		return accessor.invoke(obj, args);
	}

}
