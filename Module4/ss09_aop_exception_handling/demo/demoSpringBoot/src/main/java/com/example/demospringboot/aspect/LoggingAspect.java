package com.example.demospringboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Pointcut("execution (* com.example.demospringboot.service.BookServiceImpl.*(..))")
    public void bookService(){};

    @Before("bookService()")
    public void getLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: Call method BookService." + methodName);
    }

    @After("execution(* com.example.demospringboot.service.BookService.create(..))")
    public void getLogAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: Call method BookService." + methodName);
    }

    @Around("execution(* com.example.demospringboot.service.BookService.find*(..))")
    public Object getLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info(("Around: before method " + methodName));
        Object result = joinPoint.proceed();
        logger.info("Around: after method " + methodName);
        return result;
    }
}
