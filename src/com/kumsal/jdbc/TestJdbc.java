package com.kumsal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcConnection="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=GMT";
		String user="hbstudent";
		String password="hbstudent";
		
		try {
			System.out.println("Connecting");
			Connection connection=DriverManager.getConnection(jdbcConnection,user,password);
			System.out.println("Connection success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
