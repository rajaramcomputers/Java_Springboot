package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    String method=proceedingJoinPoint.getSignature().toShortString();
    System.out.println("\n=======>>> Executing @After method "+method);
    long begin=System.currentTimeMillis();
//    Object result=proceedingJoinPoint.proceed();
    Object result=null;
    try{
        result=proceedingJoinPoint.proceed();
    }catch(Exception exc){
        System.out.println(exc.getMessage());
//        result="Major exception averted!";
        return exc;
    }
    long end=System.currentTimeMillis();
    long duration=end-begin;
    System.out.println("\n Duration is "+duration/1000.0);
    return result;
    }
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccounts(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @After method "+method);
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "throwable")
    public void afterThrowingFindAccounts(JoinPoint joinPoint,Throwable throwable){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterThrowing method "+method);
        System.out.println("\n=======>>> Exception is "+throwable);
    }
    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))"
            ,returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning method "+method);
        System.out.println("\n=======>>> result "+result);
        convertNamesToUpperCase(result);
        System.out.println("\n=======>>> result2 "+result);
    }

    private void convertNamesToUpperCase(List<Account> result) {
        for(Account tempAccount:result){
            String x=tempAccount.getName().toUpperCase();
            tempAccount.setName(x);
        }
    }

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