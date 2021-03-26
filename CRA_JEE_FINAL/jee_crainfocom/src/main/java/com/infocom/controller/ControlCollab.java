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


@WebServlet("/test")
public class ControlCollab extends HttpServlet {
    private static final long serialVersionUID = 1L;
       

    public ControlCollab() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
          
}
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("1");

		/**
        String nomColl =request.getParameter("nomColl");
        String societeColl =request.getParameter("societeColl");
        String posteColl =request.getParameter("posteColl");
        
        request.setAttribute("nomColl", nomColl);
        request.setAttribute("societeColl", societeColl);
        request.setAttribute("posteColl", posteColl);
        **/
        System.out.print("2");
       
        Collaborateur p = new Collaborateur(5,nomColl,societeColl,posteColl);
        CollaborateurDAO d = new CollaborateurDAO();

       
		System.out.print("3");

			try {
				System.out.print("avant insert");
				d.insertCollab(p);
				System.out.print("apres insert");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("avant stc");

				e.printStackTrace();
				System.out.print("apres stc");

			}
			
			
			d.selectCollab(1);
	        request.setAttribute("testee", d);


        
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

}