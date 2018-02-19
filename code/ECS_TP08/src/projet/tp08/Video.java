package projet.tp08;

public class Video {
	private int id;
	private String nomVideo;
	private String groupeVideo;
	private int nbepisode;
	private int nbvue;
	private int nbddl;
	private double prixAchat;
	private double prixLocation;
	
	
	
	
	
	
	public Video(String nomVideo, String groupeVideo, int nbepisode, int nbvue, int nbddl, double prixAchat,
			double prixLocation) {

		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.nbepisode = nbepisode;
		this.nbvue = nbvue;
		this.nbddl = nbddl;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	public Video(int id, String nomVideo, String groupeVideo, int nbepisode, int nbvue, int nbddl, double prixAchat,
			double prixLocation) {
		super();
		this.id = id;
		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.nbepisode = nbepisode;
		this.nbvue = nbvue;
		this.nbddl = nbddl;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomVideo() {
		return nomVideo;
	}
	public void setNomVideo(String nomVideo) {
		this.nomVideo = nomVideo;
	}
	public String getGroupeVideo() {
		return groupeVideo;
	}
	public void setGroupeVideo(String groupeVideo) {
		this.groupeVideo = groupeVideo;
	}
	public int getNbepisode() {
		return nbepisode;
	}
	public void setNbepisode(int nbepisode) {
		this.nbepisode = nbepisode;
	}
	public int getNbvue() {
		return nbvue;
	}
	public void setNbvue(int nbvue) {
		this.nbvue = nbvue;
	}
	public int getNbddl() {
		return nbddl;
	}
	public void setNbddl(int nbddl) {
		this.nbddl = nbddl;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public double getPrixLocation() {
		return prixLocation;
	}
	public void setPrixLocation(double prixLocation) {
		this.prixLocation = prixLocation;
	}
	
	
}
