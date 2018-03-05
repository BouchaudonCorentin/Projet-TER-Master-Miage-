package modelservlet;

/** 
 * @param idcategorie, categorie
 * 
 * @author Corentin Bouchaudon 
 *
 */
public class CategorieClient {

	private int idcategorie;
	private String categorie;
	
	public CategorieClient(String categorie) {
		this.categorie = categorie;
	}
	public CategorieClient(int idcategorie, String categorie) {
		this.idcategorie = idcategorie;
		this.categorie = categorie;
	}
	
	public CategorieClient() {}
	public int getIdcategorie() {
		return idcategorie;
	}
	public CategorieClient(int idcategorie) {
		super();
		this.idcategorie = idcategorie;
	}
	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
