package fr.eni.gestionListesCourses.dal;

public class DAOFactory {
	public static ListesDAO getListesCoursesDAO() {
		return new ListesDaoJdbcImpl();
	}
}
