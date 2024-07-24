package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);
		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		appDAO.deleteInstructorDetail(3);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		InstructorDetail InstructorDetail=appDAO.findInstructorDetailId(2);
		System.out.println("InstructorDetail "+InstructorDetail);
	}

	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor tempInstructor=appDAO.findInstructorById(1);
		System.out.println("tempInstructor "+tempInstructor);
		System.out.println("tempInstructor detail "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://www.youtube.com/watch?v=-N95foiwZ8o","read");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		appDAO.save(tempInstructor);
	}

}
