package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Instructor;

public interface AppDao {
    void save (Instructor theinstructor);
    Instructor findInstructorById(int id);
    void deleteIstructorById(int id);
}
