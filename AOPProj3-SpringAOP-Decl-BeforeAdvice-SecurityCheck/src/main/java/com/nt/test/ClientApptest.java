package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.Authentication_manager;
import com.nt.service.BankService;

public class ClientApptest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Authentication_manager manager = null;
		BankService proxy = null;

		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get proxy Bean
		proxy = ctx.getBean("pfb", BankService.class);

		// get authentication bean
		manager = ctx.getBean("authManager", Authentication_manager.class);
		// perform signIn
		manager.SignIn("raja", "rani");

		// invoke method
		proxy.withdraw(2000, 1001);

		proxy.deposite(5000, 1001);

		// perform signOut
		manager.SignOut();

		((AbstractApplicationContext) ctx).close();
	}

}
