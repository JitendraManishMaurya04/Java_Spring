package com.springrest.springboot.basics.springrestusingspringboot.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

	@Pointcut("execution(* com.springrest.springboot.basics.springrestusingspringboot.aop.dao.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.springrest.springboot.basics.springrestusingspringboot.aop.bussiness.*.*(..))")
	public void bussinessLayerExecution() {
	}

}
