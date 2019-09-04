package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class AdminMusteriYonlendir {
	 static Connection connect=null;
	 protected static Connection DbConnect() throws SQLException{ 
			if (connect == null || connect.isClosed()) {

			   try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ticaret?" 
				+ "user=root&password=root");
				return connect;
			  }catch (ClassNotFoundException e) {
					
					System.out.println("Mysql class bulunamadý"+ e);
			  }catch (SQLException e) {
					System.out.println("Mysql db baðlantýsý kurulamadý"+ e);		
			  } 
			}
			return connect;
		}
		
		protected static void disconnect() throws SQLException {
			   if (connect != null && !connect.isClosed()) {
		            connect.close();
			   }
	        }
	
	
	public static boolean Girisuye(String customer_username, String customer_passwd){
		try {
			
			Connection connect;
			connect=DbConnect();
		
			Statement stmt = (Statement) connect.createStatement();
			ResultSet read = stmt.executeQuery("SELECT email, parola FROM tb_kullanici WHERE email= '" + customer_username + "' AND parola = '" + customer_passwd + "' ");
			if(read.next()) {
				System.out.println("VAR");
				return true;
			}else {
				System.out.println("Böyle biri yok");
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Giriþte sorun oluþtu..." + e);
		}
		return false;
	}
    public static boolean AdminMi(String kullanici_email){
        try {
            Connection connect;
            connect=DbConnect();
            
        
            Statement stmt = (Statement) connect.createStatement();
            ResultSet read = stmt.executeQuery("SELECT email,yetki FROM tb_kullanici WHERE email = '" + kullanici_email + "' ");
            if(read.next()) {
            	int yetki = read.getInt("yetki");
            	if(yetki == 1) {
                    System.out.println("Admin");
                    return true;
                }else {
                    System.out.println("Admin degil");
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println("Giriþte sorun oluþtu..." + e);
        }
        return false;
    }
	}
