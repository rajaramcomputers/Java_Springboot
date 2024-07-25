package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			deleteInstructorDetailById(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCoursesById(appDAO);
//			findInstructorWithCoursesByIdWithJoinFetch(appDAO);
//			updateInstructorWithId(appDAO);
//			updateCourseWithId(appDAO);
//			deleteInstructorByIdofCourses(appDAO);
			deleteCourseById(appDAO);
		};
	}

	private void deleteCourseById(AppDAO appDAO) {
		appDAO.deleteCourseById(10);
	}

	private void deleteInstructorByIdofCourses(AppDAO appDAO) {
		appDAO.deleteInstructorByIdOfCourses(1);
	}

	private void updateCourseWithId(AppDAO appDAO) {
		Course c=appDAO.findCourseById(10);
		c.setTitle("React - The Complete Guide 2024 (incl. Next.js, Redux)");
		appDAO.updateCourseById(c);
	}

	private void updateInstructorWithId(AppDAO appDAO) {
		Instructor i=appDAO.findInstructorById(1);
		i.setLastName("milian");
		appDAO.updateInstructorById(i);
	}

	private void findInstructorWithCoursesByIdWithJoinFetch(AppDAO appDAO) {
		Instructor i=appDAO.findCoursesByInstructorIdJOINFetch(1);
		System.out.println("courses are "+i.getCourses());
	}

	private void findInstructorWithCoursesById(AppDAO appDAO) {
		Instructor i=appDAO.findInstructorById(1);
		System.out.println("instructors are "+i.toString());
		List<Course> courses=appDAO.findCoursesByInstructorId(1);
		i.setCourses(courses);
		System.out.println("courses are "+i.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Max","Darby","max@luv2code.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://www.youtube.com/watch?v=-N95foiwZ8o","read");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course c1=new Course("React JS");
		Course c2=new Course("Java Spring Boot");
		tempInstructor.add(c1);
		tempInstructor.add(c2);
		appDAO.save(tempInstructor);
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
