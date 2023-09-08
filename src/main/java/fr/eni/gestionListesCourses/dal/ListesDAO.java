package fr.eni.gestionListesCourses.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.gestionListesCourses.bo.Ligne;
import fr.eni.gestionListesCourses.bo.Liste;

public interface ListesDAO {
	void insert(Liste listes) throws SQLException;
	List<Liste> selectListes() throws SQLException;
	List<Ligne> selectLignes(int idListe) throws SQLException;
	void checkLigne(int idLigne) throws SQLException;
	void resetLignes(int idListe)  throws SQLException; 
	void delete(int idListe) throws SQLException;
}
