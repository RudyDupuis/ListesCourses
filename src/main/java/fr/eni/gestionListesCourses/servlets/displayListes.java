package fr.eni.gestionListesCourses.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestionListesCourses.bll.ListesManager;

/**
 * Servlet implementation class displayListes
 */
@WebServlet("/mes-listes")
public class displayListes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/afficherListes.jsp");
		
		ListesManager lMng = new ListesManager();
		
		try {
			request.setAttribute("listes", lMng.getListes());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e);
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		ListesManager lMng = new ListesManager();
		int idListe = Integer.parseInt(request.getParameter("listeId"));
		
		if(request.getParameter("action").equals("Supprimer")) {
			try {
				lMng.removeListe(idListe);
				request.setAttribute("message", "Liste supprimée !");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", e);
			}
			
			doGet(request, response);;
			
		}
		
		if(request.getParameter("action").equals("Voir la liste")) {
			rd = request.getRequestDispatcher("/mon-panier");
			
			request.setAttribute("idLigne", idListe);
			
			rd.forward(request, response);
			
		}
	
	}

}
