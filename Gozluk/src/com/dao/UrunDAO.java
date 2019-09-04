package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.Urun;



public class UrunDAO {
	public static Connection connection;
   

    public UrunDAO() {
       Database connect=new Database();
    
        try {
        	connection=connect.DbConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUrun(Urun urun) {
        try {
            String query = "insert into tb_urun(adi, cinsiyet, marka_id, model, kategori, stok, fiyat, resim) values (?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, urun.getUrunAdi());
            ps.setString(2, urun.getUrunCins());
            ps.setInt(3, urun.getUrunMarkaId());
            ps.setString(4, urun.getUrunModel());;
            ps.setString(5, urun.getUrunKat());
            ps.setInt(6, urun.getUrunStok());
            ps.setInt(7, urun.getUrunFiyat());
            ps.setString(8, urun.getUrunResim());            
            ps.executeUpdate();
            System.out.println("resim ekle basarili");
        } catch (SQLException e) {
        	System.out.println("resim ekle basarisiz");
            e.printStackTrace();
        }
    }
    public void removeUrun(int urunid) {
        String query = "delete from tb_urun where u_id = " + urunid + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUrun(Urun urun) {
        String query = "update tb_urun set adi='"
        + urun.getUrunAdi() + "', cinsiyet='" 
        + urun.getUrunCins()
        + "', marka_id ='" + urun.getUrunMarkaId() 
        + "', model ='" + urun.getUrunModel() 
        + "', kategori='" + urun.getUrunKat()
        + "', stok='" + urun.getUrunStok()
        + "', fiyat='" + urun.getUrunFiyat()
        + "', resim='" + urun.getUrunResim()
        + "' where u_id = " + urun.getUrunId() + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Urun> getUrunler() throws SQLException {
        String query = "select * from tb_urun";
        ArrayList<Urun> urunler = new ArrayList<Urun>();
        Statement stmt = connection.createStatement();
        ResultSet read = stmt.executeQuery(query);
        while (read.next()) {
        	Urun urun = new Urun();
        	urun.setUrunId(read.getInt("u_id"));
        	urun.setUrunAdi(read.getString("adi"));
        	urun.setUrunCins(read.getString("cinsiyet"));
        	urun.setUrunMarkaId(read.getInt("marka_id"));
        	urun.setUrunModel(read.getString("model"));
        	urun.setUrunKat(read.getString("kategori"));
        	urun.setUrunStok(read.getInt("stok"));
        	urun.setUrunFiyat(read.getInt("fiyat"));
        	urun.setUrunResim(read.getString("resim"));
            urunler.add(urun);
        }
        return urunler;
    }
    public Urun getUrunById(int urunid) throws SQLException {
    	Urun urun = new Urun();
        String query = "select * from tb_urun where u_id = " + urunid + " ";
        Statement stmt = connection.createStatement();
        ResultSet read = stmt.executeQuery(query);
        if (read.next()) {
        	
        	urun.setUrunId(read.getInt("u_id"));
        	urun.setUrunAdi(read.getString("adi"));
        	urun.setUrunCins(read.getString("cinsiyet"));
        	urun.setUrunMarkaId(read.getInt("marka_id"));
        	urun.setUrunModel(read.getString("model"));
        	urun.setUrunKat(read.getString("kategori"));
        	urun.setUrunStok(read.getInt("stok"));
        	urun.setUrunFiyat(read.getInt("fiyat"));
        	urun.setUrunResim(read.getString("resim"));
 
        }
        return urun;
    }
    
    public static ArrayList<Urun> getUrun(int id) throws SQLException {
    	Database dbConn=new Database();
    	connection=dbConn.DbConnect();
        Statement stmt = (Statement) connection.createStatement();
        ResultSet read = stmt.executeQuery("select * from tb_urun where u_id='" + id + "' ");
        ArrayList<Urun> urun = new ArrayList<Urun>();
        while (read.next()) {
        	Urun urunum = new Urun();
        	urunum.setUrunId(read.getInt("u_id"));
        	urunum.setUrunAdi(read.getString("adi"));
        	urunum.setUrunCins(read.getString("cinsiyet"));
        	urunum.setUrunMarkaId(read.getInt("marka_id"));
        	urunum.setUrunModel(read.getString("model"));
        	urunum.setUrunKat(read.getString("kategori"));
        	urunum.setUrunStok(read.getInt("stok"));
        	urunum.setUrunFiyat(read.getInt("fiyat"));
        	urunum.setUrunResim(read.getString("resim"));
            urun.add(urunum);
        }
        return urun;
    }
    
    
}