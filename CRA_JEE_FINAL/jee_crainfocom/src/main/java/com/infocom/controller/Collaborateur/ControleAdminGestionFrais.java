package com.infocom.controller.Collaborateur;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.infocom.model.NoteDeFrais;
import com.infocom.model.DAO.NoteDeFraisDAO;


@WebServlet("/ControleAdminGestionFrais")
public class ControleAdminGestionFrais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleAdminGestionFrais() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoteDeFraisDAO notedefraisDAO = new NoteDeFraisDAO();
		List<NoteDeFrais> tabNoteDeFrais = new ArrayList(); 
		
		try {
			tabNoteDeFrais = notedefraisDAO.selectAllFrais();
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
		
		String buttonClicked = request.getParameter("button_clicked");
		
		
		if(buttonClicked != null) {
		switch(buttonClicked) {
		case"supprimerFrais":
			
			String saisiRaison = request.getParameter("saisiRaison");
			request.setAttribute("saisiRaison",saisiRaison);
			
	         NoteDeFraisDAO noteDeFraisDAO = new NoteDeFraisDAO();   
	         
	        try {
	        	noteDeFraisDAO.deleteFrais(saisiRaison);
				this.doGet(request, response);
				return;

			} catch (SQLException e) {
				e.printStackTrace();
			} 
	        break;
	        
		case"updateFrais":
		
	        
	        String idUp = request.getParameter("idUp");
	        int idUpParsed = Integer.parseInt(idUp);
	        
			String raisonUp =request.getParameter("raisonUp");
	        
	        String prixUp = request.getParameter("prixUp");
	        Double prixUpParsed = Double.parseDouble(prixUp);
	        
	        String dateUp = request.getParameter("dateUp");
		        Date date=Date.valueOf(dateUp);
			     NoteDeFrais notedefrais = new NoteDeFrais(idUpParsed,raisonUp,prixUpParsed,date, 2);
			     NoteDeFraisDAO notedefraisDAO = new NoteDeFraisDAO();
			try {
				notedefraisDAO.updateFrais(notedefrais);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
			
		case"showFrais":
	        String idSho = request.getParameter("idSho");
	        int idShoInt = Integer.parseInt(idSho);
	        
	        
			NoteDeFraisDAO notedefraisDAOAffiche = new NoteDeFraisDAO();
			List < NoteDeFrais > tabNot = new ArrayList <NoteDeFrais>(); 
			
			
			try {
				tabNot = notedefraisDAOAffiche.selectFraisCollab(idShoInt);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			request.setAttribute("tabNot",tabNot);
			break;
		}
		
        

		}
		
    	this.doGet(request, response);

        this.getServletContext().getRequestDispatcher("/WEB-INF/PageAdminGestionFrais.jsp").forward(request, response);

	}

}
