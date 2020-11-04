package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Course;
import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
			
		
			int id=1;
			Instructor tempInstructor=session.get(Instructor.class, id);
			
			Course course1=new Course("Spring bohjhjot");
			
			Course course2=new Course("Andorid studio");
			
			tempInstructor.addCourse(course1);
			tempInstructor.addCourse(course2);
			
			session.save(course1);
			session.save(course2);

			System.out.println("Saved :" +tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Saved succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}
