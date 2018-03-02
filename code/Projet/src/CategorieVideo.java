/** This class represent the different CategorieVideo we can find on the website.
 * We use this class t odefine all the categorie, like film, serie, documentary etc...
 * 
 * @param id, nomCategorieVideo
 * 
 * @author xxx
 *
 */
public class CategorieVideo {
	private int id;
	private String nomCategorieVideo;
	public CategorieVideo(int id, String nomCategorieVideo) {
		this.id = id;
		this.nomCategorieVideo = nomCategorieVideo;
	}
	public CategorieVideo(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomCategorieVideo() {
		return nomCategorieVideo;
	}
	public void setNomCategorieVideo(String nomCategorieVideo) {
		this.nomCategorieVideo = nomCategorieVideo;
	}
	
	
	
	
}
