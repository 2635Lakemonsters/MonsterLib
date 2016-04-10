package org.usfirst.frc.team2635.robot;

public class TestMain
{

	public static void main(String[] args)
	{
		ComponentConstantOutput<Double> base = new ComponentConstantOutput<Double>
		(
				2.0, 
				new ComponentSquare
				(
						new ComponentConvertType<Double, Object>
						(
								new ComponentSystemOutput(null)
						)
				)
		);
		Assembly assembly = new Assembly();
		assembly.base = base;
		assembly.run();
	}

}
