package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MusteriDAO;
import com.dto.Musteri;

/**
 * Servlet implementation class KaydolController
 */
@WebServlet("/KaydolController")
public class KaydolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KaydolController() {
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
	protected void doPost(HttpServletRequest request, 
		    HttpServletResponse response) 
		    throws ServletException, IOException {
		
				MusteriDAO musteridao = new MusteriDAO();
		
		        Musteri musteri = new Musteri();
		        musteri.setAdi(request.getParameter("adi"));
		        musteri.setSoyadi(request.getParameter("soyadi"));
		        musteri.setEmail(request.getParameter("email"));
		        musteri.setParola(request.getParameter("parola"));    
		        musteri.setYetki(0);   
		    	musteridao.kaydol(musteri);
		        response.sendRedirect("homepagewithoutlogin.jsp");
		       
		    }

}
