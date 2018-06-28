package com.nt.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.service.Authentication_manager;

public class SecurityCheckaspect implements MethodBeforeAdvice {

	private Authentication_manager am;

	public void setAm(Authentication_manager am) {
		this.am = am;
	}

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
