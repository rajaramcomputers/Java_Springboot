package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    public Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailId(int id);

    void deleteInstructorDetail(int id);
}
