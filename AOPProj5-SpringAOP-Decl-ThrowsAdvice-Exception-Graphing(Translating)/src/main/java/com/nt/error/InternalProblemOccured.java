package com.nt.error;

public class InternalProblemOccured extends Exception{

	//Here the technical raised Exception We have to convert into the project specific required Exception by using custom exception
	public InternalProblemOccured(String msg) {
		
		super(msg);
	}
}
