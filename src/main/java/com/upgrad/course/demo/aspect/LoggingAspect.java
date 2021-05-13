package com.upgrad.course.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.upgrad.course.demo..*(..))")
    public void adviceBefore(JoinPoint joinPoint)throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        System.out.println("Inside class "+ className);
        System.out.println("Entering the method "+ methodName);
    }
    @Around("execution(* com.upgrad.course.demo..*(..))")
    public Object applyLogging(ProceedingJoinPoint joinPoint)throws Throwable{
        Object result = joinPoint.proceed();
        return result;
    }

    @After("execution(* com.upgrad.course.demo..*(..))")
    public void adviceAfter(JoinPoint joinPoint)throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("exiting the method "+ methodName);

    }
}
