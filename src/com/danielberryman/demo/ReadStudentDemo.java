package com.danielberryman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danielberryman.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
										
		Session session = factory.getCurrentSession();
		
		try {
			Student daniel2 = new Student("Daniel2", "Berryman", "daniel@mail.com");
			System.out.println("Created student object: " + daniel2);
			session.beginTransaction();
			System.out.println("Begin transaction...");
			session.save(daniel2);
			System.out.println("Saving student object..." + daniel2.getId());
			session.getTransaction().commit();
			System.out.println("Commited transaction.");
			
//			READ
			session = factory.getCurrentSession();
			System.out.println("Begin transaction...");
			session.beginTransaction();
			System.out.println("Read student from DB");
			Student danielB = session.get(Student.class, daniel2.getId());
			System.out.println("Read complete: " + danielB);
			session.getTransaction().commit();
			System.out.println("Commited transaction.");
			
		} finally {
			factory.close();
		}
		
	}

}
