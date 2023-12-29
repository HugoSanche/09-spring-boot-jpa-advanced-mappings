package com.myproyects.cruddemo.dao;

import com.myproyects.cruddemo.entity.Instructor;
import com.myproyects.cruddemo.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class,theId);


        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        System.out.println("Instructor "+tempInstructorDetail.getInstructor() );
        System.out.println("Will be deleted instructor Detail "+tempInstructorDetail);

       try {
           entityManager.remove(tempInstructorDetail);
       }catch (Exception e)
       {
           System.out.println(e);
       }
    }
}






