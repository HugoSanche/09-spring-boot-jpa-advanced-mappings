package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Instructor;
import com.myproyects.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save (Instructor theinstructor);
    Instructor findInstructorById(int id);
    void deleteIstructorById(int id);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);

}
