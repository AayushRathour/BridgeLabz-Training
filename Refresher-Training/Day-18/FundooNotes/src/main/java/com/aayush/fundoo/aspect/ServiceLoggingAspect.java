package com.aayush.fundoo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Logs service calls in one place without adding logging code to every service.
@Aspect
@Component
public class ServiceLoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(ServiceLoggingAspect.class);

	// Records each service call's outcome and duration without logging sensitive arguments.
	@Around("execution(* com.aayush.fundoo.service..*(..))")
	public Object logServiceCall(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().toShortString();
		long startTime = System.currentTimeMillis();

		try {
			Object result = joinPoint.proceed();
			log.info("Service call succeeded: {} ({} ms)", method, System.currentTimeMillis() - startTime);
			return result;
		} catch (Throwable exception) {
			log.error("Service call failed: {} ({} ms)", method, System.currentTimeMillis() - startTime, exception);
			throw exception;
		}
	}
}
