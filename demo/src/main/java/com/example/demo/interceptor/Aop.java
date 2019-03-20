package com.example.demo.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Aop {
    @Pointcut("execution(public * com.example.demo.service.*.fuck())")
    public void webLog(){
    }

    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            Object o =  pjp.proceed();
            System.out.println(this);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void  main(String[] args){
        int n=10;
        int i=2;
        while(n!=1){
            int count=0;
            while(n%i==0){
                n/=i;
                count++;
            }
            if(count>0)
                System.out.println(i+" "+count);
            i++;

        }
    }
}
