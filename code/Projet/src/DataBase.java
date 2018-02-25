
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//Classe r�alis� par Corentin Bouchaudon
public class DataBase {

	private Connection conn;

	public DataBase() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cbouch3_a", "cbouch3_a", "cbouch3_a");// remettre
																													// tp-postgres
																													// �
																													// la
																													// fac
	}

	@Override
	protected void finalize() {
		try {
			if (conn != null && conn.isClosed())
				conn.close();
		} catch (Exception e) {
		}
	}

	public Client connection(Client client) throws SQLException {//connecte le client grace a pseudo et mdp
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idClient, nomClient, prenomClient,email from Client where pseudo ='"
				+ client.getPseudo() + "' and mdp = '" + client.getMdp() + "'");
		res.next();
		client.setEmail(res.getString("email"));
		client.setId(res.getInt("idClient"));
		client.setNom(res.getString("nomClient"));
		client.setPrenon(res.getString("prenomClient"));
		return client;
	}

	public Boolean verifpseudo(String pseudo) throws SQLException {//verifie si pseudo disponible
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select count(idClient) from Client where pseudo ='" + pseudo + "'");
		res.next();
		if (res.getInt(1) != 0) {
			return false;
		}else {					
			return true;
		}
	}

	public Client inscription(Client client) throws SQLException {//inscrit et connecte le client

		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select max(idClient) from Client");
		if(res.next()) {
			client.setId(res.getInt(1)+1);
		}else {
			client.setId(1);
		}
		int resultat = s.executeUpdate("insert into Client (idClient,nomClient, prenomClient, pseudo, mdp, email) values ("+
						 client.getId()+",'"+client.getNom() + "','" + client.getPrenon() + "','" + client.getPseudo() + "','" + client.getMdp()
						+ "','" + client.getEmail()+"')");
		if (resultat == 1) {
			s.executeUpdate("insert into CompoClient values("+client.getId()+", 1)");
			return client;
		}
		return new Client();
	}

	public List<Video> afficheVideos() throws SQLException {//affiche les films du plus recent au plus ancien (dans la bd)
		List<Video> videos = new ArrayList<>();
		Video video;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,prixAchat,prixLocation from Video order by idVideo DESC");

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getString("resume"),res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public List<Video> suggestions(Video v) throws SQLException {////////////a modifier pour plus de sugg
		List<Video> videos = new ArrayList();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume, nbVue,prixAchat,prixLocation from Video where nomVideo ='"
						+ v.getNomVideo() + "', and groupVideo = '" + v.getGroupeVideo() + "', and numEpisode > "
						+ v.getnumepisode());
		Video video;

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"),res.getString("resume"), res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}
		res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,prixAchat,prixLocation from Video where nomVideo ='"
						+ v.getNomVideo() + "', and groupVideo = '" + v.getGroupeVideo() + "', and numEpisode > "
						+ v.getnumepisode());
		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"),res.getString("resume"), res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public Video recupDernierID() throws SQLException {//recupere l'id de la derniere video
		String query = "SELECT max(idVideo) as idmax FROM Video";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		Video v = new Video();
		v.setId(res.getInt("idmax"));
		return v;
	}

	public List<Video> rechercheVideo(List<MotClef> mc) throws SQLException {//retourne les videos qui correspondent aux mots clefs
		List<Video> videos = new ArrayList();
		List<Video> videosreturn = new ArrayList();
		String query = "select  idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,prixAchat,prixLocation from Video where idVideo in (select idVideo from MotClefVideo where idMotClef =";
		Statement s = conn.createStatement();
		ResultSet res;
		Video video;
		res = s.executeQuery(query + mc.get(0).getId() + ")");
		for (int i = 0; i < mc.size(); i++) {
			res = s.executeQuery(query + mc.get(i).getId() + ")");
			while (res.next()) {
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"),res.getString("resume"), res.getInt("nbvue"), res.getDouble("prixAchat"),
						res.getDouble("prixLocation"));				
				videos.add(video);
			}
		}
		for (int i = 0; i < videos.size(); i++) {
			int cpt=0;
			for (int j = i; j<videos.size();j++) {
				if(videos.get(i).getId()==videos.get(j).getId()) {
					cpt++;
				}
			}
			
			if (cpt==mc.size()) {
				videosreturn.add(videos.get(i));
			}
		}
		return videosreturn;
	}

	public List<MotClef> listMotClef() throws SQLException {//retourne les mots clef
		String query = "select * from MotClef";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		List<MotClef> motclefs = new ArrayList();
		MotClef mc;
		while (res.next()) {
			mc = new MotClef(res.getInt(1), res.getString(2));
			motclefs.add(mc);
		}
		return motclefs;
	}

	public Video incrementevue(Video v) throws SQLException {//increment les vues sur la video
		String query = "Update Video Set nbvue = nbvue+1 where idVideo =" + v.getId();
		Statement s = conn.createStatement();
		int res =s.executeUpdate(query);
		if (res==1) {
			v.setNbvue(v.getNbvue()+1);
		}		
		return v;
		
	}

	public void becomePremium(Client client) throws SQLException, ClassNotFoundException {//transforme un inscrit en premium
		try {
			String query = "UPDATE CompoClient SET idCategorieClient = 2 WHERE idClient =" + client.getId();
			Statement s = conn.createStatement();
			s.executeUpdate(query);
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";
			Statement s2 = conn.createStatement();
			ResultSet res = s2.executeQuery(query);
			System.out.println("ici");
			if(res.next()) {
				System.out.println("la");
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+100";
				s2.executeUpdate(query);
			}else {
				System.out.println("ba");
				query = "select max(idCA) from ChiffreAffaire";
				res = s.executeQuery(query);
				if(res.next()) {
					System.out.println(res.getInt(1));
					query = "insert into ChiffreAffaire values ("+(res.getInt(1)+1)+",CURRENT_DATE,100)";
				}else {
					System.out.println("nnard");
					query = "insert into ChiffreAffaire values ("+1+",'CURRENT_DATE',100)";
				}
				int boobs =s.executeUpdate(query);
				System.out.println("boobs");
			}
		} catch (Exception e) {
		}
	}
	/*
	public CategorieClient categorieclient(Client c) throws SQLException{ //retourn la categorie d'un client
		CategorieClient cc= new CategorieClient();
		String query = "select * from CategorieClient cc, CompoCLient ccl where cc.idCategorieClient= ccl.idCategorieClient and ccl.idClient ="+c.getId();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		cc.setCategorie(res.getString(2));
		cc.setIdcategorie(res.getInt(1));
		return cc;
		
	}
	*/
	public List<Client> listpseudoclients()throws SQLException{//retourne la totalit� des pseudo
		List<Client> clients = new ArrayList();
		String query = "select pseudo from CLient";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			Client c = new Client(res.getString(1));
			clients.add(c);
		}		
		return clients;
	}
/*	public List<CategorieClient> liststatus() throws SQLException{//retourne les categorie de tout les user
		List<CategorieClient> cate = new ArrayList();
		String query = "select nomCategorieClient from CategorieClient cc,CompoClient ccl where cc.idCategorieClient = ccl.idCategorieClient";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			CategorieClient c = new CategorieClient(res.getString(1));
			cate.add(c);
		}		
		return cate;
	}
*/
	public double afficheCA(Date date)throws SQLException{//java fait de la merde alors il faudrait recupere
		double ca;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String datestring = df.format(date);
		System.out.println(datestring);
		String query = "select SUM(valeurCA) from ChiffreAffaire where dateCA >='"+datestring+"'";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		ca=res.getDouble(1);
		return ca;
	}

	public static void main(String[] argv) throws ClassNotFoundException, SQLException {//permet de test fonction de la bd

	}
}
