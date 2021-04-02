package com.infocom.controller.Collaborateur;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infocom.model.Collaborateur;
import com.infocom.model.NoteDeFrais;
import com.infocom.model.DAO.CollaborateurDAO;
import com.infocom.model.DAO.NoteDeFraisDAO;


@WebServlet("/ControleAdminGestionFrais")
public class ControleAdminGestionFrais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleAdminGestionFrais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("exe DoGet");
		NoteDeFraisDAO p1 = new NoteDeFraisDAO();
		List<NoteDeFrais> tabNoteDeFrais = new ArrayList(); 
		
		System.out.println("doGet1");
		try {
			System.out.println("doGet2");
			tabNoteDeFrais = p1.selectAllFrais();
			System.out.println("doGet3");

		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		request.setAttribute("tabNoteDeFrais",tabNoteDeFrais);
		ArrayList<String> tabRaisonFrais = new ArrayList<String>(); 
		for (int i = 0; i < tabNoteDeFrais.size(); i++) {
			tabRaisonFrais.add(tabNoteDeFrais.get(i).getRaison());	
		}
		request.setAttribute("tabRaisonFrais",tabRaisonFrais);
		
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionFrais.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * SUPPRIMER FRAIS VIA SELECT RAISON
		 */
		
		String saisiRaison = request.getParameter("saisiRaison");
		request.setAttribute("saisiRaison",saisiRaison);
		
         CollaborateurDAO d = new CollaborateurDAO();
        
        try {
			d.deleteCollab(saisiRaison);
			this.doGet(request, response);
	        return;

		} catch (SQLException e) {
			e.printStackTrace();
		} 

        /**
         * MAJ FRAIS
         */
        
        
        int idUp = Integer.parseInt(request.getParameter("idUp"));
		String raisonUp =request.getParameter("raisonUp");
        double prixUp = Double.parseDouble(request.getParameter("prixUp"));
        String dateUp = request.getParameter("PrixUp");
        
        
        request.setAttribute("idUp", idUp);
        request.setAttribute("raisonUp", raisonUp);
        request.setAttribute("prixUp", prixUp);
        request.setAttribute("dateUp", dateUp);
        
        Date DateUpp = null;
        
		try {
			DateUpp = new SimpleDateFormat("dd/MM/yyyy").parse(dateUp);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}  
      
        NoteDeFrais lanote = new NoteDeFrais(idUp,raisonUp,prixUp,DateUpp);
        NoteDeFraisDAO lanoteDAO = new NoteDeFraisDAO();
        
        try {
        	lanoteDAO.updateFrais(lanote);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
        
        /**
         * SHOW FRAIS
         */
        this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionFrais.jsp").forward(request, response);

	}

}
