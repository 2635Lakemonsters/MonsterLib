package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;

import edu.wpi.first.wpilibj.PIDController;

public class PIDControl extends DataProvider<Double, Double>
{
	DataProvider<?, Double> setPointProvider;

	private double P;
	private double I;
	private double D;
	private double totalError;
	private double maxOutput;
	private double minOutput;
	private double error;
	private double previousError;
	boolean isRate;
	
	public OutputOnlyDataProvider<Double> pProvider = new OutputOnlyDataProvider<Double>()
	{
		@Override
		protected Double calculateData(Void unused)
		{
			return P;
		}
		
	};
	@Override
	protected Double calculateData(Double inputData)
	{
		Double setPoint = setPointProvider.getData();
		error = setPoint - inputData;
		double result = 0;
		// The following code was adapted from WPILib's PIDController class.
		if (isRate)
		{
			if (P != 0)
			{
				double potentialPGain = (totalError + error) * P;
				if (potentialPGain < maxOutput)
				{
					if (potentialPGain > minOutput)
					{
						totalError += error;
					} else
					{
						totalError = minOutput / P;
					}
				} else
				{
					totalError = maxOutput / P;
				}

				result = P * totalError + D * error;
			}
		} else
		{
			if (I != 0)
			{
				double potentialIGain = (totalError + error) * I;
				if (potentialIGain < maxOutput)
				{
					if (potentialIGain > minOutput)
					{
						totalError += error;
					} else
					{
						totalError = minOutput / I;
					}
				} else
				{
					totalError = maxOutput / I;
				}
			}

			result = P * error + I * totalError + D * (error - previousError);
		}
		previousError = error;

		if (result > maxOutput)
		{
			result = maxOutput;
		} else if (result < minOutput)
		{
			result = minOutput;
		}
		return result;

	}

}
