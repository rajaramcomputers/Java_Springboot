package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
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
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudents(appDAO);
//			deleteCourseById(appDAO);
			deleteStudentById(appDAO);
		};
	}

	private void deleteStudentById(AppDAO appDAO) {
		Student s=appDAO.findStudentAndCoursesByStudentId(1);
		appDAO.delete(s);
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		Student s=appDAO.findStudentAndCoursesByStudentId(1);
		Course c=new Course("Spring boot -> Java");
		Course c2=new Course("AI & ML");
		s.addCourses(c);
		s.addCourses(c2);
		appDAO.update(s);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		Student s=appDAO.findStudentAndCoursesByStudentId(3);
		System.out.println("Student is "+s);
		System.out.println("Student & getCourses is "+s.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		Course c=appDAO.findCourseAndStudentsByCourseId(10);
		System.out.println("Courses is "+c);
		System.out.println("Courses & getStudents is "+c.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course c=new Course("React - The Complete Guide ");
		Student s1=new Student("John","Doe","john@luv2code.com");
		Student s2=new Student("Samoa","Joe","joe@luv2code.com");
		Student s3=new Student("Joey","Jack","joey@luv2code.com");
		c.addStudent(s1);
		c.addStudent(s2);
		c.addStudent(s3);
		appDAO.save(c);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		appDAO.deleteCourseById(10);
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		Course c=appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println("Course "+c);
		System.out.println("Course Reviews "+c.getReviews());
	}

	private void createCourseAndReview(AppDAO appDAO) {
		Course c=new Course("React - The Complete Guide 2024 (incl. Next.js, Redux) ");
		c.addReview(new Review("Nice course max!"));
		c.addReview(new Review("Content++!"));
		c.addReview(new Review("Good but confusing sometimes"));
		appDAO.save(c);
	}

	private void deleteCourseById(AppDAO appDAO) {
		appDAO.deleteCourseById(12);
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
