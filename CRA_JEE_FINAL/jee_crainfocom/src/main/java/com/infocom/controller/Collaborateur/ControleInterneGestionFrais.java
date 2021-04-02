package com.infocom.controller.Collaborateur;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infocom.model.Collaborateur;
import com.infocom.model.NoteDeFrais;
import com.infocom.model.DAO.CollaborateurDAO;
import com.infocom.model.DAO.NoteDeFraisDAO;


@WebServlet("/ControleInterneGestionFrais")
public class ControleInterneGestionFrais extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ControleInterneGestionFrais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilInterne.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String raisonIn =request.getParameter("raisonIn");
        double prixIn = Double.parseDouble(request.getParameter("prixIn"));
        String dateIn = request.getParameter("dateIn");
        
        request.setAttribute("raisonIn", raisonIn);
        request.setAttribute("prixIn", prixIn);
        request.setAttribute("dateIn", dateIn);
        
        
	
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        Date parsed = null;
			try {
				parsed = format.parse(dateIn);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
		
	        NoteDeFrais patrick = new NoteDeFrais(5,raisonIn,prixIn,parsed);
	        NoteDeFraisDAO patrickDAO = new NoteDeFraisDAO();

				try {
					patrickDAO.insertFrais(patrick);
					this.doGet(request, response);
			        return;

				} catch (SQLException e) {
					e.printStackTrace();

				} 
				
		        this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilInterne.jsp").forward(request, response);

				
	}

}