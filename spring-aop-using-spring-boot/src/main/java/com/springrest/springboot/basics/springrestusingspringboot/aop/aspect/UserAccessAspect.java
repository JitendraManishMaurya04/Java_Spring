package com.springrest.springboot.basics.springrestusingspringboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Aop
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// What kind of Method calls I would Intercept
	// execution(* PACKAGE.*.*(..))

	@Before("com.springrest.springboot.basics.springrestusingspringboot.aop.aspect.CommonPointcutConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		// Advice - What to do?

		LOGGER.info("Check for User Access");
		LOGGER.info("Intercepted Method Calls - {}", joinPoint);

	}

}
