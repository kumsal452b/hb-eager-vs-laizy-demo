package com.kumsal.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Course;
import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class CreateInstructorDemo {

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
			
			int theId=1;
			Instructor tempinstructor=session.get(Instructor.class,1);
			
			Course course1=new Course("Air guitar");
			Course course2=new Course("Hibernate");
			Course course3=new Course("Spring boot");
			Course course4=new Course("Sample java");
			List<Course> courses=new ArrayList<Course>();
			courses.add(course1);
			courses.add(course4);
			courses.add(course3);
			courses.add(course2);
			
			session.save(course4);
			session.save(course3);
			session.save(course2);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Saved succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}
