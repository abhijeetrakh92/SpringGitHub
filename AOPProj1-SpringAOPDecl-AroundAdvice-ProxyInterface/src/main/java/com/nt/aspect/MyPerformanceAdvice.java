package com.nt.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyPerformanceAdvice implements MethodInterceptor {

	private long start=0;
	private long end=0;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		System.out.println("Entering into target method");
	    start = System.currentTimeMillis();
	    retVal=invocation.proceed();
		end = System.currentTimeMillis();
		System.out.println("Exiting from target method");
		System.out.println(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments())+"has taken"+(end-start));
		
	  return retVal;
	  
	}

}
