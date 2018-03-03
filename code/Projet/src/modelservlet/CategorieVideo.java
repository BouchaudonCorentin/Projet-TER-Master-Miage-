package modelservlet;

/** This class allow to create a CategorieVideo with a specific id.
 *	Then, the idcategorie is rely to a video, to explain what categorie the video is
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
