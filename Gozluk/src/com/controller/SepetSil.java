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





/**
 * Servlet implementation class SepetSil
 */
@WebServlet("/SepetSil")
public class SepetSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SepetSil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String urunId = request.getParameter("urunId");
		System.out.println("Sepetten Sil"+urunId);
		List<Long> previousitems = (List<Long>) session.getAttribute("sepetim");
		if (previousitems == null) {
			previousitems = new ArrayList<>();
		}
		previousitems.remove(Long.valueOf(urunId));
	
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
