package com.infocom.controller.Collaborateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infocom.model.Collaborateur;
import com.infocom.model.DAO.CollaborateurDAO;

@WebServlet("/ControleConnexion")
public class ControleConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleConnexion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		String mailCo = request.getParameter("mailCo");
		String mdpCo = request.getParameter("mdpCo");

		request.setAttribute("mailCo", mailCo);
		request.setAttribute("mdpCo", mdpCo);

		CollaborateurDAO connect = new CollaborateurDAO();

		Collaborateur Baptiste = connect.ConnectCollab(mailCo);

		String mail = Baptiste.getMail();
		String mdp = Baptiste.getMdp();
		boolean type = Baptiste.getType();

		if (mail.equals(mailCo) && mdp.equals(mdpCo) && type == false) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilInterne.jsp").forward(request, response);
			System.out.println("Connection effectu�");
			
			return;

		} else if (mail.equals(mailCo) && mdp.equals(mdpCo) && type == true) {

			this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilAdmin.jsp").forward(request, response);
			return;

		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);

	}

}
