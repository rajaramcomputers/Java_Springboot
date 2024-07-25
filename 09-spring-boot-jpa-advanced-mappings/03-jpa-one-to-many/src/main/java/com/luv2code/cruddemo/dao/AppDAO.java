package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    public Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailId(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesByInstructorId(int id);
    Instructor findCoursesByInstructorIdJOINFetch(int id);
    void updateInstructorById(Instructor theInstructor);

    Course findCourseById(int id);
    void updateCourseById(Course theCourse);

    void deleteInstructorByIdOfCourses(int id);
    void deleteCourseById(int id);
}
