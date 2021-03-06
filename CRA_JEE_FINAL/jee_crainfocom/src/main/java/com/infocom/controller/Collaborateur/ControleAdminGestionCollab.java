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



@WebServlet("/ControleAdminGestionCollab")
public class ControleAdminGestionCollab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControleAdminGestionCollab() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CollaborateurDAO collabDAO = new CollaborateurDAO();
		List < Collaborateur > tabCollab = new ArrayList <Collaborateur>(); 
		
		try {
			tabCollab = collabDAO.selectAllCollab();
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
	

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buttonClicked = request.getParameter("button_clicked");
		if(buttonClicked != null) {
		switch(buttonClicked) {
		case "AjoutInterne":
			
	        String nomIn =request.getParameter("nomIn");
	        String mailIn =request.getParameter("mailIn");
	        String mdpIn =request.getParameter("mdpIn");
	       
	        
	        Collaborateur collaborateurInterne = new Collaborateur(5,nomIn,mailIn,mdpIn, false);
	        CollaborateurDAO collaborateurInterneDAO = new CollaborateurDAO();


				try {
					collaborateurInterneDAO.insertInterne(collaborateurInterne);
					this.doGet(request, response);
			        return;

				} catch (SQLException e) {
					e.printStackTrace();

				} 
				
			break;
			
		case "AjoutAdmin":
			
	        String nomInAD =request.getParameter("nomInAD");
	        String mailInAD =request.getParameter("mailInAD");
	        String mdpInAD =request.getParameter("mdpInAD");
	
	        Collaborateur collaborateurAdmin = new Collaborateur(5,nomInAD,mailInAD,mdpInAD, true);
	        CollaborateurDAO collaborateurAdminDAO = new CollaborateurDAO();

				try {
					collaborateurAdminDAO.insertAdmin(collaborateurAdmin);
					this.doGet(request, response);
			        return;

				} catch (SQLException e) {
					e.printStackTrace();

				} 
				
			break;

		case "SupprimerCollab":
			
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
            
            break;

		case "UpdateCollab":
			
			String idUp = request.getParameter("idUp");
			int idUpParsed = Integer.parseInt(idUp);		
				
			String nomUp =request.getParameter("nomUp");
	        String mailUp =request.getParameter("mailUp");
	        String mdpUp =request.getParameter("mdpUp");
	              
	        Collaborateur mathieux = new Collaborateur(idUpParsed,nomUp,mailUp,mdpUp, false);
	        CollaborateurDAO mathieuxDAO = new CollaborateurDAO();
	        
	        try {
	        	mathieuxDAO.updateCollab(mathieux);
				this.doGet(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		}
		}
        

		this.doGet(request, response);
 
	    this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionCollab.jsp").forward(request, response);
	}

	
}
