package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Calculator proxy=null;
		
		//create Ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		proxy=ctx.getBean("ca",Calculator.class);
		
		System.out.println(proxy.generateCalculation(45, 2));
		
		
		System.out.println(proxy.generateCalculation(0, 0));
		
		
		
		((AbstractApplicationContext) ctx).close();
		

	}

}
