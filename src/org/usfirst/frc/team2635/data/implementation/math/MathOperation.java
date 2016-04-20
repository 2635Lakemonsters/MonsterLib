package org.usfirst.frc.team2635.data.implementation.math;

import org.usfirst.frc.team2635.data.DataProvider;
import org.usfirst.frc.team2635.data.OutputOnlyDataProvider;
import org.usfirst.frc.team2635.data.Parameter;

public class MathOperation extends DataProvider<Double, Double>
{
	public enum Operation
	{
		/**
		 * Add a constant to inputData
		 */
		Add,
		/**
		 * Subtract a constant from inputData
		 */
		Subtract,
		/**
		 * Multiply inputData by a constant
		 */
		Multiply,
		/**
		 * Divide inputData by a constant
		 */
		Divide,
		/**
		 * Raise inputData to a constant
		 */
		Power,
	
	}
	public Parameter<Operation> operationParameter; 
	public Parameter<Double> constantParameter;


	
	private Double _calculateData(Double inputData)
	{
		double constant = constantParameter.getParameter();
		switch(operationParameter.getParameter())
		{
		case Add:
			return inputData + constant;
		case Divide:
			return inputData / constant;
		case Multiply:
			return inputData * constant;
		case Power:
			return Math.pow(inputData, constant);
		case Subtract:
			return inputData - constant;
		default:
			return null;
		
		}
	}
	@Override
	protected Double calculateData(Double inputData)
	{
		
		return _calculateData(inputData);
	}
	public MathOperation(Operation operation, Double constant)
	{
		super();
		this.operationParameter.isSetConstant(operation);
		this.constantParameter.isSetConstant(constant);
	}
	public MathOperation()
	{
		super();
	}
	
}
