package com.company.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	@Around("execution(* com.company.controller.*Controller.*(..))"
			+ " or execution(* com.company.service.*Impl.*(..))"
			+ " or execution(* com.company.mapper.*Mapper.*(..))")
	public Object longTime(ProceedingJoinPoint pjp) {
		log.info("..........@Around setting : 호출 이전 start");
		long start = System.currentTimeMillis();
		log.info("TARGET : " + pjp.getTarget());
		log.info("PARAM : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try { result = pjp.proceed(); }
		catch(Throwable e) { e.printStackTrace(); }
		
		long end = System.currentTimeMillis();
		log.info("TARGET : " + Arrays.toString(pjp.getArgs()));
		log.info("TIME : " + (end-start));
		log.info("..........@Around setting : 호출 이후 end");
		return result;
	}
}