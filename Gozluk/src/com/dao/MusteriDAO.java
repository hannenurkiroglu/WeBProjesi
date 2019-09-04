package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.Musteri;


public class MusteriDAO {
	public static Connection connection;

    public MusteriDAO() {
    	 Database connect=new Database();
        try {
        	connection=connect.DbConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMusteri(Musteri musteri) {
        try {
            String query = "insert into tb_kullanici(adi, soyadi, email, parola, yetki) values (?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, musteri.getAdi());
            ps.setString(2, musteri.getSoyadi());
            ps.setString(3, musteri.getEmail());
            ps.setString(4, musteri.getParola());;
            ps.setInt(5, musteri.getYetki());
            ps.executeUpdate();
            System.out.println("kayit basarili");
        } catch (SQLException e) {
        	System.out.println("kayit basarisiz");
            e.printStackTrace();
        }
    }
    
    public void kaydol(Musteri musteri) {
        try {
            String query = "insert into tb_kullanici(adi, soyadi, email, parola, yetki) values (?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, musteri.getAdi());
            ps.setString(2, musteri.getSoyadi());
            ps.setString(3, musteri.getEmail());
            ps.setString(4, musteri.getParola());;
            ps.setInt(5, 0);
            ps.executeUpdate();
            System.out.println("Kayýtlandýnýz");
        } catch (SQLException e) {
        	System.out.println("kayit basarisiz");
            e.printStackTrace();
        }
    }
    
    public void removeMusteri(int musteriid) {
        String query = "delete from tb_kullanici where tb_kullanici.id = " + musteriid + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMusteri(Musteri musteri) {
        String query = "update tb_kullanici set tb_kullanici.adi='"
        + musteri.getAdi() + "', tb_kullanici.soyadi='" 
        + musteri.getSoyadi()
        + "', tb_kullanici.email='" + musteri.getEmail() 
        + "', tb_kullanici.parola='" + musteri.getParola() 
        + "', tb_kullanici.yetki='" + musteri.getYetki() 
        + "' where tb_kullanici.id = " + musteri.getMusteriId() + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Musteri> getMusteriler() throws SQLException {
        String query = "select * from tb_kullanici";
        ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
        	Musteri musteri = new Musteri();
        	musteri.setMusteriId(res.getInt("id"));
        	musteri.setAdi(res.getString("adi"));
        	musteri.setSoyadi(res.getString("soyadi"));
        	musteri.setEmail(res.getString("email"));
        	musteri.setParola(res.getString("parola"));
        	musteri.setYetki(res.getInt("yetki"));
            musteriler.add(musteri);
        }
        return musteriler;
    }
    public Musteri getMusteriById(int musteriid) throws SQLException {
    	Musteri musteri = new Musteri();
        String query = "select * from tb_kullanici where tb_kullanici.id = " + musteriid + " ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        if (res.next()) {
        	
        	musteri.setMusteriId(res.getInt("id"));
        	musteri.setAdi(res.getString("adi"));
        	musteri.setSoyadi(res.getString("soyadi"));
        	musteri.setEmail(res.getString("email"));
        	musteri.setParola(res.getString("parola"));
        	musteri.setYetki(res.getInt("yetki"));
 
        }
        return musteri;
    }
}