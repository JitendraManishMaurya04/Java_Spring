package com.springrest.springboot.basics.springrestusingspringboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Aop
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// What kind of Method calls I would Intercept
	// execution(* PACKAGE.*.*(..))

	@AfterReturning(value = "com.springrest.springboot.basics.springrestusingspringboot.aop.aspect.CommonPointcutConfig.bussinessLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		// Advice - What to do?

		LOGGER.info("{} returned with value - {} ", joinPoint, result);
	}

	@AfterThrowing(value = "com.springrest.springboot.basics.springrestusingspringboot.aop.aspect.CommonPointcutConfig.bussinessLayerExecution()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		// Advice - What to do?

		LOGGER.info("{} returned with value - {} ", joinPoint, exception);
	}

	@After(value = "com.springrest.springboot.basics.springrestusingspringboot.aop.aspect.CommonPointcutConfig.bussinessLayerExecution()")
	public void afterThrowing(JoinPoint joinPoint) {
		// Advice - What to do?

		LOGGER.info("After execution of {}", joinPoint);
	}

}
