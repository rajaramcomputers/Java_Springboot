package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
