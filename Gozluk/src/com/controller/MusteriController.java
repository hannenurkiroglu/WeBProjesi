/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.MusteriDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dto.Musteri;

@WebServlet(name = "MusteriController", urlPatterns = {"/MusteriController"})
public class MusteriController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/Musteri.jsp";
    private static String list_musteri = "/ListMusteri.jsp";
    private MusteriDAO musteridao;

    public MusteriController() {
        super();
        musteridao = new MusteriDAO();
    }

    protected void doGet(HttpServletRequest request, 
    HttpServletResponse response) 
    throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
			// the other page is sending the musteri id, so we can get here and
            // call the remove method
            int musteriid = Integer.parseInt(request.getParameter("musteriId"));
            // we remove the  from the database
            musteridao.removeMusteri(musteriid);
			// set the forward string to list and put all s in request
            // attribute so we can use them inside the other page
            forward = list_musteri;
            try {
                request.setAttribute("musteriler", musteridao.getMusteriler());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // if the user is trying to edit a 
        } else if (action.equalsIgnoreCase("edit")) {

            forward = insert_or_edit;
            int musteriid = Integer.parseInt(request.getParameter("musteriId"));
            System.out.println("controller editteyim  ");
            try {
                Musteri musteri = musteridao.getMusteriById(musteriid);
                request.setAttribute("musteri", musteri);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("listMusteri")) {
            forward = list_musteri;
            System.out.println("controllerdayim ");
            try {
                request.setAttribute("musteriler", musteridao.getMusteriler());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forward = insert_or_edit;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, 
    HttpServletResponse response) 
    throws ServletException, IOException {
        Musteri musteri = new Musteri();
        musteri.setAdi(request.getParameter("adi"));
        musteri.setSoyadi(request.getParameter("soyadi"));
        musteri.setEmail(request.getParameter("email"));
        musteri.setParola(request.getParameter("parola"));    

        String yetki = request.getParameter("yetki"); 
        
        musteri.setYetki(Integer.parseInt(yetki));
        
        String musteriid = request.getParameter("musteriId");
         System.out.println("ooooo");
        System.out.println(musteriid);
		// what i'm trying to mean here is: if the id coming from the
        // request is null
        // then, the user is trying to add someone, otherwise, he's trying to
        // update someone
        if (musteriid == null || musteriid.isEmpty()) {
            musteridao.addMusteri(musteri);
            System.out.println("buradayim addmusteri");
        } else {
        	musteri.setMusteriId(Integer.parseInt(musteriid));
        	musteridao.updateMusteri(musteri);
        }

        response.sendRedirect(request.getContextPath() + "/adminpanel.jsp");
    }

}