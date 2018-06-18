package com.nt.beans;

public class IntrAmtCalculatorimpl{

	public float CalcSimpleintrAmt(float PAmt, float rate, float time) {
		System.out.println("Calculate SimpleinterestAmmount having rate="+rate);
		float SiA = PAmt*rate*time/100.0f;
		return SiA;
	}


	public float CalcCompoundintrAmt(float PAmt, float rate, float time) {
		System.out.println("Calculate CompoundinterestAmmount having rate ="+rate);
		float CiA=(float) (PAmt*Math.pow((1+rate/100), time)-PAmt);
		return CiA;
	}

}
 