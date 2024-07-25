package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager theEntityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager){
        this.theEntityManager=theEntityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
    theEntityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return theEntityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor theInstructor = theEntityManager.find(Instructor.class,id);
        theEntityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailId(int id) {
        return theEntityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int id) {
        InstructorDetail theInstructorDetail=theEntityManager.find(InstructorDetail.class,id);
        theInstructorDetail.getInstructor().setInstructorDetail(null);
        theEntityManager.remove(theInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=theEntityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",id);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findCoursesByInstructorIdJOINFetch(int id) {
        TypedQuery<Instructor> query=theEntityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:data ",Instructor.class);
        query.setParameter("data",id);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructorById(Instructor theInstructor) {
    theEntityManager.merge(theInstructor);
    }

    @Override
    public Course findCourseById(int id) {
        return theEntityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourseById(Course theCourse) {
        theEntityManager.merge(theCourse);
    }

    @Override
    @Transactional
    public void deleteInstructorByIdOfCourses(int id) {
        Instructor i=theEntityManager.find(Instructor.class,id);
        List<Course> courses=i.getCourses();
        for(Course c:courses){
            c.setInstructor(null);
        }
        theEntityManager.remove(i);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course c=theEntityManager.find(Course.class,id);
        theEntityManager.remove(c);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        theEntityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query=theEntityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id=:data",Course.class);
        query.setParameter("data",id);
        Course c=query.getSingleResult();
        return c;
    }
}
