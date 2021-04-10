package com.springrest.springboot.basics.springrestusingspringboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Aop
//Configuration
@Aspect
@Configuration
public class AroundAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// What kind of Method calls I would Intercept
	// execution(* PACKAGE.*.*(..))

	@Around(value = "com.springrest.springboot.basics.springrestusingspringboot.aop.aspect.CommonPointcutConfig.bussinessLayerExecution()")
	public void aroung(ProceedingJoinPoint joinPoint) throws Throwable {
		// Advice - What to do?
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;

		LOGGER.info("{} returned with value - {} ", joinPoint, timeTaken);
	}

}
