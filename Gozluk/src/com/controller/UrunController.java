package com.controller;

import com.dao.UrunDAO;
import com.dto.Urun;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UrunController", urlPatterns = {"/UrunController"})
public class UrunController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/Urun.jsp";
    private static String list_urun = "/ListUrun.jsp";
    private UrunDAO urundao;

    public UrunController() {
        super();
        urundao = new UrunDAO();
    }

    protected void doGet(HttpServletRequest request, 
    HttpServletResponse response) 
    throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
			// the other page is sending the musteri id, so we can get here and
            // call the remove method
            int urunid = Integer.parseInt(request.getParameter("urunId"));
            // we remove the  from the database
            urundao.removeUrun(urunid);
			// set the forward string to list and put all s in request
            // attribute so we can use them inside the other page
            forward = list_urun;
            try {
                request.setAttribute("urunler", urundao.getUrunler());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // if the user is trying to edit a 
        } else if (action.equalsIgnoreCase("edit")) {

            forward = insert_or_edit;
            int urunid = Integer.parseInt(request.getParameter("urunId"));
            System.out.println("controller editteyim  ");
            try {
                Urun urun = urundao.getUrunById(urunid);
                request.setAttribute("urun", urun);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("listurun")) {
            forward = list_urun;
            System.out.println("controllerdayim ");
            try {
                request.setAttribute("urunler", urundao.getUrunler());
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
        Urun urun = new Urun();
        
        String marka_id = request.getParameter("markaId");
        String stok = request.getParameter("stok"); 
        String fiyat = request.getParameter("fiyat"); 
        
        urun.setUrunAdi(request.getParameter("urunAdi"));
        urun.setUrunCins(request.getParameter("cinsiyet"));
        urun.setUrunMarkaId(Integer.parseInt(marka_id));
        urun.setUrunModel(request.getParameter("model"));
        urun.setUrunKat(request.getParameter("kategori"));
        urun.setUrunStok(Integer.parseInt(stok)); 
        urun.setUrunFiyat(Integer.parseInt(fiyat)); 
        urun.setUrunResim(request.getParameter("resim"));
        
        String urunid = request.getParameter("urunId");
         System.out.println("ooooo");
        System.out.println(urunid);
		// what i'm trying to mean here is: if the id coming from the
        // request is null
        // then, the user is trying to add someone, otherwise, he's trying to
        // update someone
        if (urunid == null || urunid.isEmpty()) {
            urundao.addUrun(urun);
            System.out.println("buradayim addurun");
        } else {
        	urun.setUrunId(Integer.parseInt(urunid));
        	urundao.updateUrun(urun);
        }

      //  response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

}