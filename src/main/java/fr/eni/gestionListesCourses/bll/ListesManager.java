package fr.eni.gestionListesCourses.bll;

import java.util.List;

import fr.eni.gestionListesCourses.bo.Ligne;
import fr.eni.gestionListesCourses.bo.Liste;
import fr.eni.gestionListesCourses.dal.DAOFactory;
import fr.eni.gestionListesCourses.dal.ListesDAO;

public class ListesManager {
	//TODO singleton interface
	ListesDAO dao = DAOFactory.getListesCoursesDAO();
	
	public void addListe(Liste liste) throws Exception {
		dao.insert(liste);
	}
	
	public List<Liste> getListes() throws Exception {
		return dao.selectListes();
	}
	
	public List<Ligne> getLignes(int idListe) throws Exception {
		return dao.selectLignes(idListe);
	}
	
	public void checkLigne(int idLigne) throws Exception {
		dao.checkLigne(idLigne);
	}
	
	public void resetLignes(int idListe) throws Exception {
		dao.resetLignes(idListe);
	}
	
	public void removeListe(int idListe) throws Exception {
		dao.delete(idListe);
	}
}
