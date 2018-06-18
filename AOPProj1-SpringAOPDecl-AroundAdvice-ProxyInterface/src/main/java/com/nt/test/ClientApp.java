package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.beans.IntrAmtCalculatorimpl;

public class ClientApp {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx=null;
		//ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		ctx = new FileSystemXmlApplicationContext("src\\main\\java\\com\\nt\\cfgs\\applicationContext.xml");
		//get Proxy class object
		IntrAmtCalculatorimpl proxy=null;
		proxy=ctx.getBean("pfb",IntrAmtCalculatorimpl.class);
		
		System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass());
		
		//invoke target methods
        System.out.println("Simple Interest Ammount="+proxy.CalcSimpleintrAmt(49000, 2, 12));
		
        System.out.println("Compound Interest Ammount="+proxy.CalcCompoundintrAmt(100000, 2, 12));
        
		
		
		
	}

}
