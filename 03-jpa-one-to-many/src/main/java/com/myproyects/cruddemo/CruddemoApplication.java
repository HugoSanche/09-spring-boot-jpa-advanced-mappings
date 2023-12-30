package com.myproyects.cruddemo;

import com.myproyects.cruddemo.dao.AppDao;
import com.myproyects.cruddemo.entity.Course;
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
			//deleteInstructorDetail(appDao);

			//createInstructorWithCourses(appDao);

			findTheInstructorWithCourses(appDao);



		};
	}

	private void findTheInstructorWithCourses(AppDao appDao) {
		int theId=1;
		System.out.println("Find the Instructor "+theId);

		Instructor tempInstructor=appDao.findInstructorById(theId);

		System.out.println("The Instructor "+tempInstructor);
		System.out.println("The associate course "+tempInstructor.getCourses());

		System.out.println("!Done");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Veronica", "Perez","veritoP@hotmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://www.youtube.com/channel/UCV0GXJgNgjimTFGG","Gamer");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1=new Course("Java Script - REACT ");
		Course tempCourse2=new Course("Boot Camp - Design web developer");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
		//NOTE: this will ALSO save the courses
		//because of CascadeType.PERSIS

		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses "+tempInstructor.getCourses());
		appDao.save(tempInstructor);

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
