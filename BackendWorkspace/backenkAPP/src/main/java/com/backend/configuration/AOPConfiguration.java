package com.backend.configuration;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Aspect
public class AOPConfiguration {

	
	
	@Before(value="execution(* com.backend.*.*.*(..))")
	public void before(JoinPoint joinpoint) {
		log.info("LOG :: before method called started");
		Arrays.asList(joinpoint.getArgs()).forEach(S->{
			
			log.info("LOG :: Parameters ::"+S);
		});
		
		log.info("LOG :: before method called end");
	}
	
	@AfterReturning(value="execution(* com.backend.*.*.*(..))",returning ="result" )
	public void afterReturn(JoinPoint joinpoint,Object result) {
		log.info("LOG :: After return "+result);
	}
	
	
	@Around(value = "execution(* com.backend.*.*.*(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Long st = System.currentTimeMillis();
		Object obj=proceedingJoinPoint.proceed();
		
		Long et = System.currentTimeMillis();
		log.info("LOG :: " + proceedingJoinPoint + " time taken :: " + (et - st));
		return obj;
	}
		
		
	
}