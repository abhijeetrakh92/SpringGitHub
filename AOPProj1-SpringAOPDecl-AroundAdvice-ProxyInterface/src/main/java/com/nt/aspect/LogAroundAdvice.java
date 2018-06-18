package com.nt.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogAroundAdvice implements MethodInterceptor{

	private static Logger logger=Logger.getLogger(LogAroundAdvice.class);
	
	static {
		
		PropertyConfigurator.configure("src/main/java/com/nt/commons/log4j.properties");
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		
		logger.info(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
        
		args=invocation.getArguments();
		
		//modify the argument values here 
		if(((float)args[0] )<= 50000) {
			args[1]=((float)args[1])- 0.5f;
		}
		
		if(((float)args[0])<=0 || ((float)args[1]) <= 0 || ((float)args[2]) <= 0) {
			
			throw new IllegalArgumentException();
			
		}else {
			
			retVal = invocation.proceed();
		}
		
		
		retVal=((float)retVal)+((float)retVal)*0.01f;
		
			logger.info(invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		return retVal;
	}

	

	

}
