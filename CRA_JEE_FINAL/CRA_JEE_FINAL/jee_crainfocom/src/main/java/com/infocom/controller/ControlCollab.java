package com.infocom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infocom.model.Collaborateur;
import com.infocom.model.DAO.CollaborateurDAO;


@WebServlet("/accueil")
public class ControlCollab extends HttpServlet {
    private static final long serialVersionUID = 1L;
       

    public ControlCollab() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        
}
        

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomColl =request.getParameter("nomColl");
        String societeColl =request.getParameter("societeColl");
        String posteColl =request.getParameter("posteColl");
        
        request.setAttribute("nomColl", nomColl);
        request.setAttribute("societeColl", societeColl);
        request.setAttribute("posteColl", posteColl);
        
       
        CollaborateurDAO d = new CollaborateurDAO();
        Collaborateur p = new Collaborateur(5,nomColl,societeColl,posteColl);
        

       
        try {
			d.insertCollab(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

}