package fr.eni.gestionListesCourses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestionListesCourses.bll.ListesManager;

@WebServlet("/mon-panier")
public class displayPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherPanier.jsp");
		int idListe = (int) request.getAttribute("idLigne");
		ListesManager lMng = new ListesManager();
		
		try {
			request.setAttribute("lignes", lMng.getLignes(idListe));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e);
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListesManager lMng = new ListesManager();
		int idListe = Integer.parseInt(request.getParameter("listeId"));
		
		if(request.getParameter("action").equals("Retirer")) {
			int idLigne = Integer.parseInt(request.getParameter("ligneId"));
			
			try {
				lMng.checkLigne(idLigne);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e);
			}
			
		}
		
		if(request.getParameter("action").equals("Retablir le panier")) {
			try {
				lMng.resetLignes(idListe);;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e);
			}
			
		}
		
		request.setAttribute("idLigne", idListe);
		
		doGet(request, response);
	}

}
