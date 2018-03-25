package modelservlet;

public class Parrain {
	private int idParrain;
	private int idNeveu;
	private int nbpoints;
	private int nbvideo;
	public int getIdParrain() {
		return idParrain;
	}
	public void setIdParrain(int idParrain) {
		this.idParrain = idParrain;
	}
	public int getIdNeveu() {
		return idNeveu;
	}
	public void setIdNeveu(int idNeveu) {
		this.idNeveu = idNeveu;
	}
	public int getNbpoints() {
		return nbpoints;
	}
	public void setNbpoints(int nbpoints) {
		this.nbpoints = nbpoints;
	}
	public int getNbvideo() {
		return nbvideo;
	}
	public void setNbvideo(int nbvideo) {
		this.nbvideo = nbvideo;
	}
	public Parrain() {
		super();
	}
	public Parrain(int idParrain) {
		super();
		this.idParrain = idParrain;
	}
	public Parrain(int idNeveu, int nbpoints, int nbvideo) {
		super();
		this.idNeveu = idNeveu;
		this.nbpoints = nbpoints;
		this.nbvideo = nbvideo;
	}
	
	
}