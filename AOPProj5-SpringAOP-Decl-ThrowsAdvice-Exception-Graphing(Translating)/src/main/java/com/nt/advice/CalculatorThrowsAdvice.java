package com.nt.advice;

import org.springframework.aop.ThrowsAdvice;

import com.nt.error.InternalProblemOccured;

public class CalculatorThrowsAdvice implements ThrowsAdvice{

	
	public void afterThrowing(IllegalArgumentException ie) throws InternalProblemOccured {
		
		System.out.println("afterThrowing method CalculatorThrowsAdvice");
		throw new InternalProblemOccured(ie.getMessage());
		
	}
	
	public void afterThrowing(Exception e) throws InternalProblemOccured {
		
		throw new InternalProblemOccured(e.getMessage());
		
	}
	
	
}
