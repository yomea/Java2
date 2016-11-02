package com.bjsxt.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Handler {
	@Before("execution(* com.bjsxt.service.UserService.add(..))")
	public void before() {
		System.out.println("before...");
	}
	@After("execution(* com.bjsxt.service.UserService.*(..))")
	public void after() {
		System.out.println("after...");
	}
	@AfterReturning("execution(* com.bjsxt.service.*.add(..))")
	public void afterReturning() {
		System.out.println("afterReturning...");
	}

	
}
