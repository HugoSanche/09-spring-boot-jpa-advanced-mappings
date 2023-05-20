package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImp implements AppDao{

    EntityManager entityManager;

    public AppDaoImp(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Transactional
    @Override
    public void save(Instructor theinstructor) {
        entityManager.persist(theinstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Transactional
    @Override
    public void deleteIstructorById(int id) {
        //search the instructor to delete
        Instructor tempInstructor=entityManager.find(Instructor.class,id);
        System.out.println("Instructor "+tempInstructor);
        try {
            entityManager.remove(tempInstructor);
        }catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("########");
    }
}
