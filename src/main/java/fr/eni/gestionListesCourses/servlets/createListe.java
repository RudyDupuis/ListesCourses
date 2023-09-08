package fr.eni.gestionListesCourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.gestionListesCourses.bll.ListesManager;
import fr.eni.gestionListesCourses.bo.Ligne;
import fr.eni.gestionListesCourses.bo.Liste;

/**
 * Servlet implementation class createListe
 */
@WebServlet("/cree-liste")
public class createListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/creeListe.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/creeListe.jsp");
		
		Liste liste = new Liste(request.getParameter("title"));
		List<Ligne> lignes = new ArrayList<>();
		
		lignes.add(new Ligne(request.getParameter("article1")));
		
		if(!request.getParameter("article2").isEmpty()) {
			lignes.add(new Ligne(request.getParameter("article2")));
		}
		if(!request.getParameter("article3").isEmpty()) {
			lignes.add(new Ligne(request.getParameter("article3")));
		}
		if(!request.getParameter("article4").isEmpty()) {
			lignes.add(new Ligne(request.getParameter("article4")));
		}
		if(!request.getParameter("article5").isEmpty()) {
			lignes.add(new Ligne(request.getParameter("article5")));
		}
		
		liste.setLignes(lignes);
		
		ListesManager lMng = new ListesManager();
		
		try {
			lMng.addListe(liste);
			request.setAttribute("message", "Liste créée !");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e);
		}
		
		rd.forward(request, response);
		
	}

}
