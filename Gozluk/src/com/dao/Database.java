package com.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Database {

	     static Connection connect=null;
	        
	    public Connection DbConnect() throws SQLException{ 
	        if (connect == null || connect.isClosed()) {

	           try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ticaret?" 
	            + "user=root&password=root");
	           
	            return connect;
	          }catch (ClassNotFoundException e) {
	                
	                System.out.println("Mysql class bulunamadı"+ e);
	          }catch (SQLException e) {
	                System.out.println("Mysql db bağlantısı kurulamadı"+ e);        
	          } 
	        }
	        return connect;
	    }
	    
	    protected static void disconnect() throws SQLException {
	           if (connect != null && !connect.isClosed()) {
	                connect.close();
	           }
	       }
	    
	}

