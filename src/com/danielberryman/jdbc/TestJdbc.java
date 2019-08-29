package com.danielberryman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.hibernate.dialect.Database;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pw = "hbstudent";
		try {
			System.out.println("Connecting to database...");
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("Connection SUCCESS!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
