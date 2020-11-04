package com.kumsal.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kumsal.demo.entity.Course;
import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class EagerLeazyDemo {

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

			Query<Instructor>  query=session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.course "
					+ "where i.id=:theInstructorId",Instructor.class);
			query.setParameter("theInstructorId", theId);
			
			Instructor tempinstructor=query.getSingleResult();
			
			System.out.println("Instructor "+tempinstructor);
			
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Done succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}
