package com.nt.service;

public class Calculator {

	public float generateCalculation(float number1,float number2){
		
		if(number1==0||number2==0) {
			
			throw new IllegalArgumentException("Invalid inputs");
		}else {
			
			return number1*number2;
		}
		
		
	}
	
	
}
