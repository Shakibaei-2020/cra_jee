package com.infocom.controller.Collaborateur;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.infocom.model.NoteDeFrais;
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
		

		String buttonClicked = request.getParameter("button_clicked");
	
		if(buttonClicked != null) {
		switch(buttonClicked) {
		case "ajoutFrais":
			
			String raisonIn =request.getParameter("raisonIn");
	        Double prixIn = Double.parseDouble(request.getParameter("prixIn"));
	        String dateIn = request.getParameter("dateIn");
	        int idIn = Integer.parseInt(request.getParameter("idIn")); 

	        Date date=Date.valueOf(dateIn);

	        NoteDeFrais noteDeFrais = new NoteDeFrais(5,raisonIn,prixIn,date, idIn);
	        NoteDeFraisDAO noteDeFraisDAO = new NoteDeFraisDAO();
			     
			try {
				noteDeFraisDAO.insertFrais(noteDeFrais);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
	
			     this.doGet(request, response);
			     return;			
			}
		
	}
				
		        this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilInterne.jsp").forward(request, response);		
	}

}
