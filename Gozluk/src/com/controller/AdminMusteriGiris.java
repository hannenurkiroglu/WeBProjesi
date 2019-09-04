package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminMusteriYonlendir;

@WebServlet("/AdminMusteriGiris")
public class AdminMusteriGiris extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminMusteriGiris() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
        String parola = request.getParameter("pass");
        AdminMusteriYonlendir musteri= new AdminMusteriYonlendir();
        boolean mevcut= musteri.Girisuye(username, parola);
        boolean yetkiliMi= musteri.AdminMi(username);
        	
         if(mevcut) {
        	 //	 RequestDispatcher rd = request.getRequestDispatcher("./jsp/anasayfa.jsp");
        	// rd.forward(request, response);
        	 // response.sendRedirect("./html/hello.html");
      
        	 
        	 if(yetkiliMi == true) {
        		 HttpSession session= request.getSession(true);
            	 session.setAttribute("oturumismi", username);
            	 session.setAttribute("uyeyok", false);
            	  response.sendRedirect("adminpanel.jsp");
             
                 
             }
             else {
            	 HttpSession session= request.getSession(true);
            	 session.setAttribute("oturumismi", username);
            	 session.setAttribute("uyeyok", false);
                 response.sendRedirect("homepagewithoutlogin.jsp");
                 
             }
   
         }

         else {
      
       	 HttpSession session= request.getSession(true);
       	 session.setAttribute("uyeyok", true );
 
       	 response.sendRedirect("signinpage.jsp");

   	       } 
	}
	}

	
 
	
	


