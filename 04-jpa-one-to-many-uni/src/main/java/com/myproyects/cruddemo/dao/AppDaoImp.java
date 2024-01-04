package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Course;
import com.myproyects.cruddemo.entity.Instructor;
import com.myproyects.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImp implements AppDao {

    EntityManager entityManager;

    public AppDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theinstructor) {
        entityManager.persist(theinstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Transactional
    @Override
    public void deleteIstructorById(int id) {
        //search the instructor to delete
        Instructor tempInstructor = entityManager.find(Instructor.class, id);
        System.out.println("Instructor " + tempInstructor);



        //get courses
        List<Course> courses=tempInstructor.getCourses();
        for (Course tempCourse:courses){
            tempCourse.setInstructor(null);
        }
        try {
            entityManager.remove(tempInstructor);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("########");
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);


        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        System.out.println("Instructor " + tempInstructorDetail.getInstructor());
        System.out.println("Will be deleted instructor Detail " + tempInstructorDetail);

        try {
            entityManager.remove(tempInstructorDetail);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);

        query.setParameter("data", theId);

        //execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theID) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "JOIN FETCH i.instructorDetail "
                + "where i.id=:data", Instructor.class);

        query.setParameter("data", theID);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }


    @Transactional
    @Override
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Transactional
    @Override
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
       return entityManager.find(Course.class,theId);
    }

    @Transactional
    @Override
    public void deleteCourseByID(int theId) {

        //retrieve the course
        Course tempCourse=entityManager.find(Course.class,theId);

        //Remove the course
        entityManager.remove(tempCourse);
    }
}













