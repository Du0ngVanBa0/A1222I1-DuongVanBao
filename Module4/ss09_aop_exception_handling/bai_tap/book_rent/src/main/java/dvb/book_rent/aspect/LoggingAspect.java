package dvb.book_rent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static long visitors = 0;
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution (* dvb.book_rent.controller.RentController.rent(..))")
    public void rent(){};

    @Pointcut("execution (* dvb.book_rent.controller.RentController.giveBack(..))")
    public void giveBack(){};

    @Before("rent(), giveBack()")
    public void getLogBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: Call method " + methodName);
    }

    @After("rent(), giveBack()")
    public void getLogAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: Call method " + methodName);
    }

    @After("execution(* dvb.book_rent.controller.BookController.showList(..))")
    public void getLogVisit(JoinPoint joinPoint) {
        logger.info("number Visitor: "+ ++visitors);
    }
}
