package modelservlet;

/** This class represent the Client. We use this class to define which information we need to be connected.
 * 
 * @param id, nom, prenom, pseudo, mdp, email
 * 
 * @author lenor
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
	
	public Client(String pseudo, String mdp){
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	public Client(int id){
		this.id=id;
	}
	
	public Client(int id, String nom, String prenon, String pseudo, String mdp, String email) {
		this.id = id;
		this.nom = nom;
		this.prenon = prenon;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
	}
	
	public Client(String nom, String prenon, String pseudo, String mdp, String email) {
		this.nom = nom;
		this.prenon = prenon;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
	}
	

	public Client(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenon() {
		return prenon;
	}
	public void setPrenon(String prenon) {
		this.prenon = prenon;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
