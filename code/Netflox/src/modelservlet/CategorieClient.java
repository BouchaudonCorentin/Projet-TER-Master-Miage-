package modelservlet;

import java.util.Date;

/** 
 * @param idcategorie, categorie
 * 
 * @author Corentin Bouchaudon 
 *
 */
public class CategorieClient {

	/**
	 * @param finPremium
	 */
	public void setFinPremium(Date finPremium) {
		this.finPremium = finPremium;
	}
	private int idcategorie;
	private String categorie;
	private Date finPremium;
	
	/**
	 * @param categorie
	 */
	public CategorieClient(String categorie) {
		this.categorie = categorie;
	}
	/**
	 * @param idcategorie
	 * @param categorie
	 */
	public CategorieClient(int idcategorie, String categorie) {
		this.idcategorie = idcategorie;
		this.categorie = categorie;
	}
	
	/**
	 * 
	 */
	public CategorieClient() {}
	public int getIdcategorie() {
		return idcategorie;
	}
	/**
	 * @param idcategorie
	 */
	public CategorieClient(int idcategorie) {
		super();
		this.idcategorie = idcategorie;
	}
	/**
	 * @param idcategorie
	 */
	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}
	/**
	 * @return
	 */
	public String getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return
	 */
	public Date getFinPremium() {
		return finPremium;
	}
	/**
	 * @param finPremium
	 */
	public void setCategorie(Date finPremium) {
		this.finPremium = finPremium;
	}
	
}
