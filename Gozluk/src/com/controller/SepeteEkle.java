package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UrunDAO;
import com.dto.Urun;

/**
 * Servlet implementation class SepeteEkle
 */
@WebServlet("/SepeteEkle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SepeteEkle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//INT URUNID=GETPARAMETER;
		int id=3;
			HttpSession session = request.getSession();

			ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("sepet"); 
			try {
			sepet.addAll(UrunDAO.getUrun(id));
				request.getSession().setAttribute("sepet",sepet);
				System.out.println("IDSÝ GÝRÝLEN ÜRÜN SEPETE EKLENDÝ"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("products.jsp");
		}
			//request.getSession().setAttribute("sepet",urunid);

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
