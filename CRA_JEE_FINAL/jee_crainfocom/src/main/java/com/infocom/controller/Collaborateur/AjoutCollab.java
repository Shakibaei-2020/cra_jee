package com.infocom.controller.Collaborateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infocom.model.Collaborateur;
import com.infocom.model.DAO.CollaborateurDAO;


@WebServlet("/ajoutCollab")
public class AjoutCollab extends HttpServlet {
    private static final long serialVersionUID = 1L;
       

    public AjoutCollab() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollaborateurDAO p1 = new CollaborateurDAO();
		List < Collaborateur > tabCollab = new ArrayList <Collaborateur>(); 
		try {
			tabCollab = p1.selectAllCollab();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.setAttribute("tabCollab",tabCollab);
		ArrayList<String> tabNomColl = new ArrayList<String>(); 
		for (int i = 0; i < tabCollab.size(); i++) {
			tabNomColl.add(tabCollab.get(i).getnomCollab());	
		}
		request.setAttribute("tabNomColl",tabNomColl);
		
		
		

	this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	
	}
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		CollaborateurDAO p1 = new CollaborateurDAO();
		List < Collaborateur > tabCollab = new ArrayList <Collaborateur>(); 
		try {
			tabCollab = p1.selectAllCollab();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.setAttribute("tabCollab",tabCollab);
		ArrayList<String> tabNomColl = new ArrayList<String>(); 
		for (int i = 0; i < tabCollab.size(); i++) {
			tabNomColl.add(tabCollab.get(i).getnomCollab());	
		}
		request.setAttribute("tabNomColl",tabNomColl);
		
		
        String nomColl =request.getParameter("nomColl");
        String societeColl =request.getParameter("societeColl");
        String posteColl =request.getParameter("posteColl");
        
        request.setAttribute("nomColl", nomColl);
        request.setAttribute("societeColl", societeColl);
        request.setAttribute("posteColl", posteColl);
        
        Collaborateur p = new Collaborateur(5,nomColl,societeColl,posteColl);
        CollaborateurDAO d = new CollaborateurDAO();

			try {
				d.insertCollab(p);
			} catch (SQLException e) {
				e.printStackTrace();

			}

	
			

			
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        
        
    }

}