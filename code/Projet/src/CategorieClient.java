/** This class contains the different CategorieClient we can find on the website
 * like Client, or PremiumClient. We use the idcategorie, which is rely to the idcategorie of
 * each Video
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
