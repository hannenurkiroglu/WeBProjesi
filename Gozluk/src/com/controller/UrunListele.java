package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Database;
import com.dto.Urun;


@WebServlet("/UrunListele")
public class UrunListele extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Connection connect=null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrunListele() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	        PreparedStatement preparedStatement;
	        ResultSet resultSet;
	        List<Urun> urunListesi = new ArrayList<Urun>();
	        
	        try {
	            Database dbConnection= new Database();
	            connect = dbConnection.DbConnect();
	            preparedStatement = (PreparedStatement) connect.prepareStatement("SELECT * FROM tb_urun");
	            resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	             
	                int urunId = resultSet.getInt("u_id") ;
	                String urunAdi = resultSet.getString("adi");
	                String urunKat  = resultSet.getString("kategori");
	                String urunModel  = resultSet.getString("model");
	                int urunMarkaId = resultSet.getInt("marka_id") ;;
	                int urunStok = resultSet.getInt("stok");
	                int urunFiyat = resultSet.getInt("fiyat");
	                String urunCins = resultSet.getString("cinsiyet");
	                String urunResim  = resultSet.getString("resim");
	                   System.out.println(urunId);
	                   System.out.println(urunAdi );
	                   System.out.println(urunKat);
	                   System.out.println(urunModel);
	                   System.out.println(urunMarkaId);
	                   System.out.println(urunStok);
	                   System.out.println(urunFiyat);
	               Urun urun = new Urun(urunId, urunAdi, urunKat, urunModel, urunMarkaId, urunStok, urunFiyat, urunCins, urunResim );
	                urunListesi.add(urun);
	                System.out.println("");
	            }
	        }catch(SQLException e ){
	            e.printStackTrace();
	            System.out.printf("Sqle baðlanýlamadý", e);
	        }
	       
	        HttpSession session = request.getSession();
	        session.setAttribute("urunListesi", urunListesi);
	       
	        response.sendRedirect("products.jsp");
	    
	        doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	// BÜYÜK ÝHTÝMALLE DOGET YERÝNE DOPOST YAPICAZ DOGET OLDUÐU ÝÇÝN JSP YÝ GET EDÝYOR, BU SERVLETÝ ÇALIÞTIRINCA JSPYÝ DÝREKT 
	//GET EDÝP GÖSTERÝYOR. AMA DOPOST YAPARSAK LÝSTEYÝ JSPYE POST EDECEK BÖYLECE SERVLETÝ DÝREKT ÇALIÞTIRINCA URUNLERÝ GÖRMEYECEÐÝZ
	

	}




