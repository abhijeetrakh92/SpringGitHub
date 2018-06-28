package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=null;
		Map<String,Object> cacheMap = new HashMap();
		
		//get method and args as keys
		key = invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		
		if(!cacheMap.containsKey(key)) {
			
			
			
			retVal=invocation.proceed();
		    cacheMap.put(key, retVal);
		    
		}else {
			
			System.out.println("from cache");
			cacheMap.get(key);
		}
		
		
		
		
		
		return retVal;
	}

}
