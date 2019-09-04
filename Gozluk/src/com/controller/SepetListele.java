package com.controller;

import java.io.IOException;
import java.sql.Connection;
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

import com.mysql.jdbc.PreparedStatement;





/**
 * Servlet implementation class SepetListele
 */
@WebServlet("/SepetListele")
public class SepetListele extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connect=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SepetListele() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    PreparedStatement preparedStatement;
	        ResultSet resultSet;
	       
	        HttpSession session = request.getSession();
	        List<Urun> urunSepet = new ArrayList<Urun>();
	        
	        List<Long> previousitemsId = (List<Long>) session.getAttribute("sepetim");
	        System.out.println("Listelede" +previousitemsId);
	        
	    	if (previousitemsId == null) {
				session.setAttribute("urunSepet", null);
				response.sendRedirect("sepetim.jsp");
				
			}
			int toplamTutar=0;
	        
	        try {
	        	Database dbConnection= new Database();
	  	        connect = (Connection) dbConnection.DbConnect();
	        	for (Long urunid : previousitemsId) {
	        	
	        		 preparedStatement = (PreparedStatement) connect.prepareStatement("SELECT * FROM tb_urun WHERE u_id = '" + urunid+ "'");
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
	                urunSepet.add(urun);
	                System.out.println("");
	                toplamTutar=toplamTutar + urunFiyat;
	            }
	        	}
	        }catch(SQLException e ){
	            e.printStackTrace();
	            System.out.printf("Sqle baðlanýlamadý", e);
	        }
	       
	   
	        session.setAttribute("urunSepet", urunSepet);
	        session.setAttribute("toplamTutar", toplamTutar);
	        response.sendRedirect("sepetim.jsp");

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
