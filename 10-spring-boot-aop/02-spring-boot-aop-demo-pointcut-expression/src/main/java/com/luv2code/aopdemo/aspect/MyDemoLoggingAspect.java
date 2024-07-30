package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");
        MemberSignature memberSignature=(MemberSignature) theJoinPoint.getSignature();
        System.out.println("Method "+memberSignature);
        Object args[]=theJoinPoint.getArgs();
        for(Object tempArg:args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                Account theAccount=(Account) tempArg;
                System.out.println("theAccount.getName()   "+theAccount.getName());
                System.out.println("theAccount.getLevel()   "+theAccount.getLevel());
            }
        }
    }

}