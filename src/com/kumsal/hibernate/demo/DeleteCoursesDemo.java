package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Course;
import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class DeleteCoursesDemo {

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
			int id=14;
		
			Course tempCourse=session.get(Course.class, 14);
			
			tempCourse.getInstructor().setCourse(null);
			
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Delete succesfuly");
		} finally {
			session.close();
			sessionFactory.close();
			// TODO: handle finally clause
		}

	}

}
