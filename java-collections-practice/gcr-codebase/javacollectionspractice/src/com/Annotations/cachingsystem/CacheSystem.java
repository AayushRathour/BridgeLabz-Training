package com.annotations.cachingsystem;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CacheSystem {
	public static HashMap<String, Integer> cache = new HashMap<>();
	
	static Integer invoke(Object obj, String methodName, String args) throws Exception{
		Class<?> class1 = obj.getClass();
		
		Method method = class1.getMethod(methodName, String.class);
		
		if(method.isAnnotationPresent(CacheResult.class)) {
			String key = methodName + args.toString();
			
			if(cache.containsKey(key)) return cache.get(key);
			
			int result = (int) method.invoke(obj, args);
			cache.put(key, result);
			return result;
		}
		return (Integer) method.invoke(obj, args);
	}
}
