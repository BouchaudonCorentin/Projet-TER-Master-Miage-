package modelservlet;

/** 
 * 
 * @param id, nomCategorieVideo
 * 
 * @author Corentin Bouchaudon
 *
 */
//Created by Corentin Bouchaudon
public class CategorieVideo {
	/**
	 * 
	 */
	private int id;
	private String nomCategorieVideo;
	/**
	 * @param id
	 * @param nomCategorieVideo
	 */
	public CategorieVideo(int id, String nomCategorieVideo) {
		this.id = id;
		this.nomCategorieVideo = nomCategorieVideo;
	}
	/**
	 * @param id
	 */
	public CategorieVideo(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getNomCategorieVideo() {
		return nomCategorieVideo;
	}
	/**
	 * @param nomCategorieVideo
	 */
	public void setNomCategorieVideo(String nomCategorieVideo) {
		this.nomCategorieVideo = nomCategorieVideo;
	}
	
	
	
	
}
