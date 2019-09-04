package com.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


@WebServlet("/SepetEkle")
public class SepetEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SepetEkle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String urunId = request.getParameter("urunId");
		
		System.out.println("Sepete ekle"+urunId);
		
		List<Long> previousitems = (List<Long>)session.getAttribute("sepetim");
		
		if (previousitems == null) {
			previousitems = new ArrayList<>();
			System.out.println("pre yi olusturdumu");
		}
		
		previousitems.add(Long.valueOf(urunId));
		
		System.out.println(previousitems);
		
		session.setAttribute("sepetim",previousitems);
		response.sendRedirect("SepetListele");
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
