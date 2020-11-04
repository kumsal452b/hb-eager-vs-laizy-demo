package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
			
			Instructor tempInstructor=new Instructor("Alatas", "Kumsal", "kumsal@gmail.com");
			
			InstructorDetail tempInsDetail=new InstructorDetail("kumsalYoutube", "i like to read books");
			session=sessionFactory.getCurrentSession();
			tempInstructor.setInstructorDetail(tempInsDetail);
			
			
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
