package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService trafficFortuneService) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceHandleRethrownException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleRethrownException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program Demo the Around advice");
		boolean tripWire=true;
		String data=trafficFortuneService.getFortune(true);
		System.out.println("\n My fortune is "+data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program Demo the Around advice");
		boolean tripWire=true;
		String data=trafficFortuneService.getFortune(true);
		System.out.println("\n My fortune is "+data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program Demo the Around advice");
		String data=trafficFortuneService.getFortune();
		System.out.println("\n My fortune is "+data);
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		try {
			boolean tripWire=false;
			List<Account> accounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception e){
			System.out.println("Main program caught exception "+e);
		}
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
	try {
		boolean tripWire=true;
		List<Account> accounts = theAccountDAO.findAccounts(tripWire);
	}catch (Exception e){
		System.out.println("Main program caught exception "+e);
	}
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts=theAccountDAO.findAccounts();

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}







