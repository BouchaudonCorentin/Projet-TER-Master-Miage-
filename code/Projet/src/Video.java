

public class Video {
	private int id;
	private String nomVideo;
	private String groupeVideo;
	private int numepisode;
	private int nbvue;
	private double prixAchat;
	private double prixLocation;
	
	
	
	
	
	
	public Video(String nomVideo, String groupeVideo, int numepisode, int nbvue, double prixAchat,
			double prixLocation) {

		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
		this.nbvue = nbvue;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	public Video(int id, String nomVideo, String groupeVideo, int numepisode, int nbvue,  double prixAchat,
			double prixLocation) {
		super();
		this.id = id;
		this.nomVideo = nomVideo;
		this.groupeVideo = groupeVideo;
		this.numepisode = numepisode;
		this.nbvue = nbvue;
		this.prixAchat = prixAchat;
		this.prixLocation = prixLocation;
	}
	public Video () {}
	
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
	public int getnumepisode() {
		return numepisode;
	}
	public void setnumepisode(int numepisode) {
		this.numepisode = numepisode;
	}
	public int getNbvue() {
		return nbvue;
	}
	public void setNbvue(int nbvue) {
		this.nbvue = nbvue;
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
