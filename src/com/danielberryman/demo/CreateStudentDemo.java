package com.danielberryman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danielberryman.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
										
		Session session = factory.getCurrentSession();
		
		try {
			Student grace = new Student("Grace", "Berryman", "grace@mail.com");
			System.out.println("Created student object: " + grace);
			System.out.println("Id = " + grace.getId());
			session.beginTransaction();
			System.out.println("Begin transaction...");
			session.save(grace);
			System.out.println("Saving student object...");
			System.out.println("Id = " + grace.getId());
			session.getTransaction().commit();
			System.out.println("Commited transaction.");
		} finally {
			factory.close();
		}
		
	}

}
