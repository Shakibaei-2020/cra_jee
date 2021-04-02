package com.infocom.controller.Collaborateur;

import java.io.IOException;
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

/**
 * Servlet implementation class Controle1Admin
 */
@WebServlet("/ControleAdminGestionCollab")
public class ControleAdminGestionCollab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControleAdminGestionCollab() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("exe DoGet");
		CollaborateurDAO p1 = new CollaborateurDAO();
		List < Collaborateur > tabCollab = new ArrayList <Collaborateur>(); 
		
		System.out.println("doGet1");
		try {
			System.out.println("doGet2");
			tabCollab = p1.selectAllCollab();
			System.out.println("doGet3");

		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		request.setAttribute("tabCollab",tabCollab);
		ArrayList<String> tabNomColl = new ArrayList<String>(); 
		for (int i = 0; i < tabCollab.size(); i++) {
			tabNomColl.add(tabCollab.get(i).getNom());	
		}
		request.setAttribute("tabNomColl",tabNomColl);
		
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionCollab.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		String saisiNom = request.getParameter("saisiNom");
		request.setAttribute("saisiNom",saisiNom);
		
         CollaborateurDAO d = new CollaborateurDAO();
        
        try {
			d.deleteCollab(saisiNom);
			this.doGet(request, response);
	        return;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
        
        
		/**
		 * TAB
		 */
        /**
		System.out.println("doPost1");

		CollaborateurDAO p1 = new CollaborateurDAO();
		List < Collaborateur > tabCollab = new ArrayList <Collaborateur>(); 
		try {
			System.out.println("doPost2");
			tabCollab = p1.selectAllCollab();
			System.out.println("doPost3");
			this.doGet(request, response);
	        
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		request.setAttribute("tabCollab",tabCollab);
		ArrayList<String> tabNomColl = new ArrayList<String>(); 
		for (int i = 0; i < tabCollab.size(); i++) {
			tabNomColl.add(tabCollab.get(i).getNom());	
		}
		request.setAttribute("tabNomColl",tabNomColl);
		
		**/
		/**
		 **************** INSERT**************
		*/
		
        String nomIn =request.getParameter("nomIn");
        String mailIn =request.getParameter("mailIn");
        String mdpIn =request.getParameter("mdpIn");
        
        request.setAttribute("nomIn", nomIn);
        request.setAttribute("mailIn", mailIn);
        request.setAttribute("mdpIn", mdpIn);
        
        Collaborateur patrick = new Collaborateur(5,nomIn,mailIn,mdpIn, false);
        CollaborateurDAO patrickDAO = new CollaborateurDAO();

			try {
				patrickDAO.insertInterne(patrick);
				this.doGet(request, response);
		        return;

			} catch (SQLException e) {
				e.printStackTrace();

			} 
		
		
			/**
			 * UPDATE
			 */
			
			int idUp = Integer.parseInt(request.getParameter("idUp"));
			String nomUp =request.getParameter("nomUp");
	        String mailUp =request.getParameter("mailUp");
	        String mdpUp =request.getParameter("mdpUp");
	        
	        request.setAttribute("idUp", idUp);
	        request.setAttribute("nomUp", nomUp);
	        request.setAttribute("mailUp", mailUp);
	        request.setAttribute("mdpUp", mdpUp);
	      
	        Collaborateur mathieux = new Collaborateur(idUp,nomUp,mailUp,mdpUp, false);
	        CollaborateurDAO mathieuxDAO = new CollaborateurDAO();
	        
	        try {
	        	mathieuxDAO.updateCollab(mathieux);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        

		
	        this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionCollab.jsp").forward(request, response);
	}

}