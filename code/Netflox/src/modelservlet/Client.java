package modelservlet;

/**
 * 
 * @param id, nom, prenom, pseudo, mdp, email
 * 
 * @author corentin Bouchaudon
 *
 */
//Created by Corentin Bouchaudon
public class Client {
	private int id;
	private String nom;
	private String prenon;
	private String pseudo;
	private String mdp;
	private String email;
	
	public Client(){};
	
	/**
	 * @param pseudo
	 * @param mdp
	 */
	public Client(String pseudo, String mdp){
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	/**
	 * @param id
	 */
	public Client(int id){
		this.id=id;
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenon
	 * @param pseudo
	 * @param mdp
	 * @param email
	 */
	public Client(int id, String nom, String prenon, String pseudo, String mdp, String email) {
		this.id = id;
		this.nom = nom;
		this.prenon = prenon;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
	}
	
	/**
	 * @param nom
	 * @param prenon
	 * @param pseudo
	 * @param mdp
	 * @param email
	 */
	public Client(String nom, String prenon, String pseudo, String mdp, String email) {
		this.nom = nom;
		this.prenon = prenon;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
	}
	

	/**
	 * @param pseudo
	 */
	public Client(String pseudo) {
		this.pseudo = pseudo;
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
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return
	 */
	public String getPrenon() {
		return prenon;
	}
	/**
	 * @param prenon
	 */
	public void setPrenon(String prenon) {
		this.prenon = prenon;
	}
	/**
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
