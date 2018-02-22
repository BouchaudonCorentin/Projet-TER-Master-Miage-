
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public Client connection(Client client) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idClient, nomClient, prenomClien, email from Client where pseudo ='"
				+ client.getPseudo() + "' and mdpClient = '" + client.getMdp() + "'");
		res.next();
		client.setEmail(res.getString("email"));
		client.setId(res.getInt("idClient"));
		client.setNom(res.getString("nomClient"));
		client.setPrenon(res.getString("prenomClient"));
		return client;
	}

	public Boolean verifpseudo(String pseudo) throws SQLException {
		Boolean ok = true;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select count(*) as num from Client where pseudo ='" + pseudo + "'");
		res.next();
		if (res.getInt("num") != 0) {
			ok = false;
		}
		return ok;
	}

	public Client inscription(Client client) throws SQLException {

		Statement s = conn.createStatement();
		int res = s
				.executeUpdate("insert into Client (nomClient, prenomClient, pseudoCLient, mdpClient, email) values ("
						+ client.getNom() + "," + client.getPrenon() + "," + client.getPseudo() + "," + client.getMdp()
						+ "," + client.getEmail());
		if (res == 1) {
			client = connection(client);
		}
		return client;
	}

	public List<Video> afficheVideo() throws SQLException {
		List<Video> videos = new ArrayList<>();
		Video video;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,prixAchat,prixLocation from Video order by idVideo DESC");

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public List<Video> suggestions(Video v) throws SQLException {
		List<Video> videos = new ArrayList();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,prixAchat,prixLocation from Video where nomVideo ='"
						+ v.getNomVideo() + "', and groupVideo = '" + v.getGroupeVideo() + "', and numEpisode > "
						+ v.getnumepisode());
		Video video;

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}
		res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,prixAchat,prixLocation from Video where nomVideo ='"
						+ v.getNomVideo() + "', and groupVideo = '" + v.getGroupeVideo() + "', and numEpisode > "
						+ v.getnumepisode());
		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public Video recupDernierID() throws SQLException {
		String query = "SELECT max(idVideo) as idmax FROM Video";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		Video v = new Video();
		v.setId(res.getInt("idmax"));
		return v;
	}

	public List<Video> rechercheVideo(List<MotClef> mc) throws SQLException {
		List<Video> videos = new ArrayList();
		List<Video> videosreturn = new ArrayList();
		String query = "select  idVideo,nomVideo,groupeVideo,numEpisode,nbVue,prixAchat,prixLocation from Video where idVideo in (select idVideo from MotClefVideo where idMotClef =";
		Statement s = conn.createStatement();
		ResultSet res;
		Video video;
		res = s.executeQuery(query + mc.get(0).getId() + ")");
		for (int i = 0; i < mc.size(); i++) {
			res = s.executeQuery(query + mc.get(i).getId() + ")");
			while (res.next()) {
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"), res.getInt("nbvue"), res.getDouble("prixAchat"),
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

	public List<MotClef> listMotClef() throws SQLException {
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

	public void incrementevue(Video v) throws SQLException {
		String query = "Update Video Set nbvue = nbvue+1 where idVideo =" + v.getId();
		Statement s = conn.createStatement();
		s.executeUpdate(query);
	}

	public void BecomePremium(Client client) throws SQLException, ClassNotFoundException {
		try {
			String query = "UPDATE CompoClient SET idCategorieClient = 2 WHERE idClient =" + client.getId();
			Statement s = conn.createStatement();
			s.executeUpdate(query);
		} catch (Exception e) {
		}
	}

	public static void main(String[] argv) throws ClassNotFoundException, SQLException {
		DataBase db = new DataBase();
		List<MotClef> test = new ArrayList();
		test.add(new MotClef(3));
		test.add(new MotClef(7));
		test.add(new MotClef(11));
		List<Video> v = db.rechercheVideo(test);
		System.out.println(v.size());
		if (v.size() < 0) {
			System.out.println("erreur");
		} else {
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i).getNomVideo());
			}
		}
	}
}
