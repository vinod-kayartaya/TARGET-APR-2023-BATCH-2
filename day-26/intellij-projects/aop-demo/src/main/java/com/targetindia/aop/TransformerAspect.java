package com.targetindia.aop;

import com.targetindia.dao.DaoException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransformerAspect {

    @Around("execution(* com..ProductDao(double, double))")
    public Object ensureAscOrderForParameters(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        double d1 = (double) args[0];
        double d2 = (double) args[1];
        if (d1 > d2) {
            args = new Object[]{d2, d1};
        }
        return pjp.proceed(args);
    }

    @AfterThrowing(pointcut = "execution(* com..ProductDao.*(..))", throwing = "e")
    public void convertToDaoException(Exception e){
        throw new DaoException(e);
    }
}
