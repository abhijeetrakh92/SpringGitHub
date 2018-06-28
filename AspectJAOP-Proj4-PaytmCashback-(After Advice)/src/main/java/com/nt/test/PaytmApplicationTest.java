package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.PaytmCashback;

public class PaytmApplicationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PaytmCashback proxy=null;
		
		
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		proxy=ctx.getBean("pay",PaytmCashback.class);
		
		System.out.println("bill="+proxy.purchase(new String[]{"Tea","cofeee","sambar","chai"}));
		
		
	}
}
