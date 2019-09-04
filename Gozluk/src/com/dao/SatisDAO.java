package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.Musteri;
import com.model.Satis;

public class SatisDAO {
	public static Connection connection;

    public SatisDAO() {
    	 Database connect=new Database();
        try {
        	connection=connect.DbConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSatis(Satis satis) {
        try {
        	
            String query = "insert into tb_satislar(kullanici_id, u_id, toplam_tutar) values (?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, satis.getKullanicid());
            ps.setFloat(2, satis.getUrunid());
            ps.setInt(3, satis.getTutar());
           
            ps.executeUpdate();
            System.out.println("Sipariþ oluþtu");
        } catch (SQLException e) {
        	System.out.println("kayit basarisiz");
            e.printStackTrace();
        }
    }
}
