package modelservlet;

/** This class allow to create a CategorieCLient with a specific id.
 * Then, the idcategorie is rely to a client, to explain what categorie the client is.	
 * 
 * @param idcategorie, categorie
 * 
 * @author 
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
