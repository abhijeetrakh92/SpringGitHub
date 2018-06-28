package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.JoinPoint;

public class PaytmCashbackAdvice {
	FileWriter fw=null;
	String couponMsg=null;
	
	public void cashback(float bill) throws IOException {
		
		if(bill>=5000) {
			
			couponMsg="20% Cashback on next deal";
		}if(bill>=10000) {
			
			couponMsg="40% Cashback on next deal";
		}if(bill>=15000) {
			
			couponMsg="60% Cashback on next deal";
		}else {
			
			couponMsg="80% Cashback on next deal";
		}
		
		
		fw=new FileWriter("Coupon.txt");
		fw.write(couponMsg);
		fw.flush();
		fw.close();
	}

}
