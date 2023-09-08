package fr.eni.gestionListesCourses.bo;

public class Ligne {
	private int id;
	private String article;
	private int idListe;
	private boolean isBuy;
	
	public Ligne() {
	}

	public Ligne(int id, String article, int idListe, boolean isBuy) {
		this.id = id;
		this.article = article;
		this.idListe = idListe;
		this.isBuy = isBuy;
	}

	public Ligne(String article, int idListe, boolean isBuy) {
		this.article = article;
		this.idListe = idListe;
		this.isBuy = isBuy;
	}
	
	public Ligne(String article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public int getIdListe() {
		return idListe;
	}

	public void setIdListe(int idListe) {
		this.idListe = idListe;
	}

	public boolean getBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
}
