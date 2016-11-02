package com.bjsxt.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Handler {
	@Pointcut("execution(* com.bjsxt.service..*.*(..)))")
	public void myMethod(){}
	//@Before("execution(* com.bjsxt.service.UserService.add(..))")
	@Before("myMethod()")
	public void before() {
		System.out.println("before...");
	}
	//@After("execution(* com.bjsxt.service.UserService.*(..))")
	@After("myMethod()")
	public void after() {
		System.out.println("after...");
	}
	//@AfterReturning("execution(* com.bjsxt.service.*.add(..))")
	@AfterReturning("myMethod()")
	public void afterReturning() {
		System.out.println("afterReturning...");
	}
	@Around("myMethod()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		System.out.println("around start...");
		obj = pjp.proceed();
		System.out.println("around end...");
		return obj;
	}
	@AfterThrowing("myMethod()")
	public void AfterThrowing() {
		System.out.println("AfterThrowing...");
	}

	
}
