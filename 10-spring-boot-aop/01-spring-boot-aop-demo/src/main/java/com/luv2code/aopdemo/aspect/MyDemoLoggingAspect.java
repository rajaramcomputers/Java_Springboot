package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(* com.luv2code.aopdemo.dao.AccountDAO.addAcount(..))")
//@Before("execution(public void addAccount())")
//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
@Before("execution(public * add*())")
    public void beforeAddAccountMethod(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
