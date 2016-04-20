package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

public class PIDInfo
{
	private double P;
	private double I;
	private double D;
	private double maxOutput;
	private double minOutput;
	private double error;
	boolean isRate;
	public OutputOnlyDataProvider<Double> pProvider;
	public OutputOnlyDataProvider<Double> iProvider;
	public OutputOnlyDataProvider<Double> dProvider;

}
