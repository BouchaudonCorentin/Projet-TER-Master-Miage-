package modelservlet;

public class Parrain {
	private int idParrain;
	private int idNeveu;
	private int nbpoints;
	private int nbvideo;
	/**
	 * @return
	 */
	public int getIdParrain() {
		return idParrain;
	}
	/**
	 * @param idParrain
	 */
	public void setIdParrain(int idParrain) {
		this.idParrain = idParrain;
	}
	/**
	 * @return
	 */
	public int getIdNeveu() {
		return idNeveu;
	}
	/**
	 * @param idNeveu
	 */
	public void setIdNeveu(int idNeveu) {
		this.idNeveu = idNeveu;
	}
	/**
	 * @return
	 */
	public int getNbpoints() {
		return nbpoints;
	}
	/**
	 * @param nbpoints
	 */
	public void setNbpoints(int nbpoints) {
		this.nbpoints = nbpoints;
	}
	/**
	 * @return
	 */
	public int getNbvideo() {
		return nbvideo;
	}
	/**
	 * @param nbvideo
	 */
	public void setNbvideo(int nbvideo) {
		this.nbvideo = nbvideo;
	}
	/**
	 * 
	 */
	public Parrain() {
		super();
	}
	/**
	 * @param idParrain
	 */
	public Parrain(int idParrain) {
		super();
		this.idParrain = idParrain;
	}
	/**
	 * @param idNeveu
	 * @param nbpoints
	 * @param nbvideo
	 */
	public Parrain(int idNeveu, int nbpoints, int nbvideo) {
		super();
		this.idNeveu = idNeveu;
		this.nbpoints = nbpoints;
		this.nbvideo = nbvideo;
	}
	
	
}