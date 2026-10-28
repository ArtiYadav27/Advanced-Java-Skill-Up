package com.arti.aopDemo.aspect;

import com.arti.aopDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SimpleAspect {

    @Before("@annotation(jdk.jfr.Timestamp)")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted.");
    }

//    @Around("@annotation(com.arti.aopDemo.annotation.TrackExecutionTime)") //--- type matching form
    @Around("@annotation(trackExecutionTime)") //binding form
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, TrackExecutionTime trackExecutionTime) throws Throwable {
        Long startTime=System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }
        finally {
            Long duration=System.currentTimeMillis()-startTime;
            String operation=trackExecutionTime.operation();
            if(!operation.isBlank()){
                operation=joinPoint.getSignature().getName();
            }
            long warningThreshold=trackExecutionTime.warnAfter();
            if(duration>=warningThreshold){
                System.out.println("SLOW OPERATION ALERT:"+
                        "Time taken by :"+ operation +":"+duration
                );
            }
            else {System.out.println("Total execution time by "+operation+"-> " + duration);}
        }
    }
}
