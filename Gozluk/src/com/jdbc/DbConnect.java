package com.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConnect {
	
	private final String database;
	private String messageDb;
	
	public Connection getConnection() {;
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,
					"root","root");
			
		}catch(SQLException | ClassNotFoundException ex) {
			setMessageDb(ex.getMessage());
		}
		return cn;
	}

	public DbConnect() {
		this.database = "e-ticaret";
	}
	
	public DbConnect(String database) {
		this.database = database;
	}
	
	public String getMessageDb() {
		return messageDb;
	}
	
	private void setMessageDb(String messageDb) {
		this.messageDb = messageDb;		
	}
	
}
