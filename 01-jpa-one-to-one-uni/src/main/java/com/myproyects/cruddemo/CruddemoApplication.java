package com.myproyects.cruddemo;

import com.myproyects.cruddemo.dao.AppDao;
import com.myproyects.cruddemo.entity.Instructor;
import com.myproyects.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
			//createInstructor(appDao);
			//findTheInstructor(appDao);
			//deleteInstructor(appDao);

			//findTheInstructorDetail(appDao);
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId=6;
		System.out.println("Delete instructor detail "+theId);
		 appDao.deleteInstructorDetailById(theId);
		System.out.println("Finish");

	}

	private void findTheInstructorDetail(AppDao appDao) {
		int id=1;

		System.out.println("We found the id "+id);
		InstructorDetail tempInstructorDetail=new InstructorDetail();

		tempInstructorDetail=appDao.findInstructorDetailById(id);

		System.out.println("We found the instructor detail "+tempInstructorDetail);

		System.out.println("We found the instructor"+tempInstructorDetail.getInstructor() );
	}

	private void deleteInstructor(AppDao appDao) {
		int id=1;
		System.out.println("Delete the id; "+id);
		appDao.deleteIstructorById(id);
		System.out.println("Finish");
	}

	private void findTheInstructor(AppDao appDao) {
		int id=1;
		System.out.println("We found the id "+id);
		Instructor tempIstructor=appDao.findInstructorById(id);
		System.out.println("The instructor; "+tempIstructor);
		System.out.println("Instructor Detail: "+tempIstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

		Instructor instructor=new Instructor("Veronica", "Perez","veritoP@hotmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("https://www.youtube.com/channel/UCV0GXJgNgjimkXJIGT-ZB1Q","Travel");

	//	Instructor instructor=new Instructor("Eduardo", "Perez","Eperez@hotmail.com");
	//	InstructorDetail instructorDetail=new InstructorDetail("https://www.youtube.com/channel/UCV0GXJgNg","GYM");


		//asociate the objects
		instructor.setInstructorDetail(instructorDetail);

		//save the instructor
		//
		//NOTE: this will ALSO save the details object
		//because of cascadeType.ALL
		//
		System.out.println("Saving instructor: "+instructor);
		appDao.save(instructor);
		System.out.println("Done!");


	}
}
