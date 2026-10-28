package com.arti.aopDemo.annotation;


import java.lang.annotation.*;


//marker annotation
//on providing extra information it becomes configured annotation- which can be done through methods in annotation interface
@Target(ElementType.METHOD)//restricting the annotation to be used with methods only, when no meta annotation is provided to ques WHERE it is applicable to all-methods,class, parameters, constructor etc
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 2000;//making it configured annotation

    String operation() default "";
}
