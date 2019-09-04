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
import com.model.Musteri;
import com.model.Satis;
import com.dao.SatisDAO;


@WebServlet("/Ode")
public class Ode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static Connection connect=null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Musteri musteri = null;
		if (session.getAttribute("oturumismi")!=null) {
			String email= (String) session.getAttribute("oturumismi");
			 PreparedStatement preparedStatement;
		        ResultSet resultSet;
		        
		        try {
		            Database dbConnection= new Database();
		            connect = dbConnection.DbConnect();
		            preparedStatement = (PreparedStatement) connect.prepareStatement("SELECT * FROM tb_kullanici WHERE email= '" + email + "' ");
		            resultSet = preparedStatement.executeQuery();
		            while (resultSet.next()) {
		             
		                int id = resultSet.getInt("id") ;
		                String adi = resultSet.getString("adi");
		                String soyadi  = resultSet.getString("soyadi");
		                String mail  = resultSet.getString("email");
		                String parola = resultSet.getString("parola") ;;
		                int yetki = resultSet.getInt("yetki");
		            
		                   System.out.println(id);
		                   System.out.println(adi );
		                   System.out.println(soyadi);
		                   System.out.println(email);
		                   System.out.println(parola);
		                   System.out.println(yetki);
		                
		               musteri = new Musteri(id, adi,soyadi, mail, parola, yetki);
		              
		                System.out.println("");
		                Satis siparis= new Satis();
		 		       SatisDAO satisdao = new SatisDAO();
		 		      int i;
		 		   
		 		   List<Long> previousitemsId = (List<Long>) session.getAttribute("sepetim");
		 		    	   
		 	for (i=0; i < previousitemsId.size(); i++){
		 		    	
		 			       siparis.setKullanicid(musteri.getId());
		 			    
		 			       siparis.setUrunid(previousitemsId.get(i));
		 			       siparis.setTutar((Integer) session.getAttribute("toplamTutar"));
		 			       satisdao.addSatis(siparis);
		 			       
		 		       }
		            }
		        }catch(SQLException e ){
		            e.printStackTrace();
		            System.out.printf("Sqle baðlanýlamadý", e);
		        }
		       session.setAttribute("musteriid", musteri.getId());
		       session.setAttribute("musteriadi", musteri.getAdi());
		       session.setAttribute("musterisoyadi", musteri.getSoyadi());
		       response.sendRedirect("End.jsp");
		       
		       	
		} else {
			System.out.println("KULLANICI GÝRÝÞSÝZ");
		       response.sendRedirect("signinpage.jsp");
		}	
			doGet(request, response);

}}
