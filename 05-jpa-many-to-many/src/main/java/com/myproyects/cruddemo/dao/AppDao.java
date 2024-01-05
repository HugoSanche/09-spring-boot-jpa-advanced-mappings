package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Course;
import com.myproyects.cruddemo.entity.Instructor;
import com.myproyects.cruddemo.entity.InstructorDetail;
import com.myproyects.cruddemo.entity.Student;

import java.util.List;

public interface AppDao {
    void save (Instructor theinstructor);
    Instructor findInstructorById(int id);
    void deleteIstructorById(int id);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theID);

    void update(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCourseById(int theId);
    void deleteCourseByID(int theId);
    void saveCourse(Course tempCourse);

    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);
    void updateStudent(Student tempStudent);

    void deleteStudentById(int theId);

}
