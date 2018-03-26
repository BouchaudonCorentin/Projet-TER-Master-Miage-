package modelservlet;

/** 
 * 
 * @param id, nomVideo, groupeVideo, resume, numepisode, nbvue, nbddl, prixAchat, prixLocation
 * 
 * @author Corentin Bouchaudon
 *
 */
//Created by Corentin Bouchaudon
public class Video {
	private int id;
	private String nomVideo;
	private String groupeVideo;
	private String resume;
	private int numepisode;
	private int nbvue;
	private int nbddl;
	private double prixAchat;
	private double prixLocation;
	
	
	
	/**
	 * @param nomVideo
	 * @param groupeVideo
	 * @param numepisode
	 */
	public Video(String nomVideo, String groupeVideo, int numepisode) {
		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
	}
	
	
	/**
	 * @param nomVideo
	 * @param groupeVideo
	 * @param numepisode
	 * @param resume
	 * @param nbvue
	 * @param nbddl
	 * @param prixAchat
	 * @param prixLocation
	 */
	public Video(String nomVideo, String groupeVideo, int numepisode, String resume, int nbvue,int nbddl, double prixAchat,
			double prixLocation) {

		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
		this.nbvue = nbvue;
		this.nbddl = nbddl;
		this.resume=resume;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	/**
	 * @return
	 */
	public int getNbddl() {
		return nbddl;
	}


	/**
	 * @param nbddl
	 */
	public void setNbddl(int nbddl) {
		this.nbddl = nbddl;
	}


	/**
	 * @param id
	 * @param nomVideo
	 * @param groupeVideo
	 * @param numepisode
	 */
	public Video(int id,String nomVideo, String groupeVideo, int numepisode) {
		this.id=id;
		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
	}
	/**
	 * @return
	 */
	public String getResume() {
		return resume;
	}
	/**
	 * @param resume
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}
	/**
	 * @return
	 */
	public int getNumepisode() {
		return numepisode;
	}
	/**
	 * @param numepisode
	 */
	public void setNumepisode(int numepisode) {
		this.numepisode = numepisode;
	}
	/**
	 * @param id
	 * @param nomVideo
	 * @param groupeVideo
	 * @param numepisode
	 * @param resume
	 * @param nbvue
	 * @param nbddl
	 * @param prixAchat
	 * @param prixLocation
	 */
	public Video(int id, String nomVideo, String groupeVideo, int numepisode, String resume, int nbvue,int nbddl,  double prixAchat,
			double prixLocation) {
		this.id = id;
		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
		this.nbvue = nbvue;
		this.nbddl = nbddl;
		this.resume=resume;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	/**
	 * @param nomVideo
	 */
	public Video(String nomVideo) {
		this.nomVideo = nomVideo;
	}


	public Video () {}
	/**
	 * @param id
	 */
	public Video (int id) {
		this.id=id;
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
	public String getNomVideo() {
		return nomVideo;
	}
	/**
	 * @param nomVideo
	 */
	public void setNomVideo(String nomVideo) {
		this.nomVideo = nomVideo;
	}
	/**
	 * @return
	 */
	public String getGroupeVideo() {
		return groupeVideo;
	}
	/**
	 * @param groupeVideo
	 */
	public void setGroupeVideo(String groupeVideo) {
		this.groupeVideo = groupeVideo;
	}
	/**
	 * @return
	 */
	public int getNbvue() {
		return nbvue;
	}
	/**
	 * @param nbvue
	 */
	public void setNbvue(int nbvue) {
		this.nbvue = nbvue;
	}

	/**
	 * @return
	 */
	public double getPrixAchat() {
		return prixAchat;
	}
	/**
	 * @param prixAchat
	 */
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	/**
	 * @return
	 */
	public double getPrixLocation() {
		return prixLocation;
	}
	/**
	 * @param prixLocation
	 */
	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}
	
	
}
