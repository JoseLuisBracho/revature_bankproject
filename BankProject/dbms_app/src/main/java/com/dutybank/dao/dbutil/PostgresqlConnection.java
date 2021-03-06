package com.dutybank.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection {
	// Using to create a singleton object (design pattern) for connection
	
	private static Connection connection;
	
	private PostgresqlConnection() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "postgres";
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

}
