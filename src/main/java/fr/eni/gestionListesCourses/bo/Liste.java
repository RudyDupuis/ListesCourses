package fr.eni.gestionListesCourses.bo;

import java.util.List;

public class Liste {
	private int id;
	private String title;
	private List<Ligne> lignes;

	public Liste() {
		super();
	}

	public Liste(int id, String title) {
		this.id = id;
		this.title = title;
	}



	public Liste(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Ligne> getLignes() {
		return lignes;
	}

	public void addLignes(Ligne ligne) {
		this.lignes.add(ligne);
	}
	
	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}
	
	

}
