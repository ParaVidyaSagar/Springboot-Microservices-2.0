package com.custom.starter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.custom.starter.annotation.LogExecutionTime;

@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around("@annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        Object proceed = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - startTime;
        
        logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        
        return proceed;
    }
}