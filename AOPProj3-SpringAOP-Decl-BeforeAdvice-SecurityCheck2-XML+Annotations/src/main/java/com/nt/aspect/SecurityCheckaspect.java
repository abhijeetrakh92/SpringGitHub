package com.nt.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.nt.service.Authentication_manager;

public class SecurityCheckaspect implements MethodBeforeAdvice {
     
	
	@Autowired
	private Authentication_manager am;

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		boolean flag = false;
		flag = am.isValidate();

		if (flag == true) {
			System.out.println("Authentication suceeded");
		} else {

			throw new IllegalAccessException("Invalid Username and password");

		}

	}

}
