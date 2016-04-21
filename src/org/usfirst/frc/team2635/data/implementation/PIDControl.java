package org.usfirst.frc.team2635.data.implementation;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;
import org.usfirst.frc.team2635.data.DataProviderSetup;

import edu.wpi.first.wpilibj.PIDController;

public class PIDControl extends DataProvider<Double, Double>
{
	public Parameter<Double> setPointParameter = new Parameter<>();
	public Parameter<Double> PParameter = new Parameter<>();
	public Parameter<Double> IParameter = new Parameter<>();
	public Parameter<Double> DParameter = new Parameter<>();
	public Parameter<Double> maxOutputParameter = new Parameter<>();
	public Parameter<Double> minOutputParameter = new Parameter<>();
	public Parameter<Double> errorParameter = new Parameter<>();
	public Parameter<Boolean> isRateParameter = new Parameter<>();

	private double previousError;
	private double totalError;

	
	@Override
	protected Double calculateData(Double inputData)
	{
		double setPoint = setPointParameter.getParameter();
		
		double P = PParameter.getParameter();
		double I = IParameter.getParameter();
		double D = DParameter.getParameter();
		
		double maxOutput = maxOutputParameter.getParameter();
		double minOutput = minOutputParameter.getParameter();
		
		boolean isRate = isRateParameter.getParameter();
		
		
		double error = setPoint - inputData;
		errorParameter.setParameter(error);
		
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
	public PIDControl(DataProviderSetup<PIDControl> setupRoutine)
	{
		super();
		
		setupRoutine.setup(this);
	}
}
