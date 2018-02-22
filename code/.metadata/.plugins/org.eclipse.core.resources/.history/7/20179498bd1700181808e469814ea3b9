
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
		conn = DriverManager.getConnection("jdbc:postgresql://tp-postgres:5432/cbouch3_a", "cbouch3_a", "cbouch3_a");
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
		ResultSet res = s
				.executeQuery("select idClient, nomClient, prenomClien, email from Client where pseudo ='"
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
				"select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,nbTelechargement,prixAchat,prixLocation from Video order by idVideo DESC");

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getInt("nbTelechargement"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public List<Video> suggestions(Video v) throws SQLException {
		List<Video> videos = new ArrayList();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,nbTelechargement,prixAchat,prixLocation from Video where nomVideo ='"+v.getNomVideo()+"', and groupVideo = '"+v.getGroupeVideo()+"', and numEpisode > "+v.getNbepisode());
		Video video;

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getInt("nbTelechargement"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
		}
		res = s.executeQuery("select idVideo,nomVideo,groupeVideo,numEpisode,nbVue,nbTelechargement,prixAchat,prixLocation from Video where nomVideo ='"+v.getNomVideo()+"', and groupVideo = '"+v.getGroupeVideo()+"', and numEpisode > "+v.getNbepisode());
		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getInt("nbvue"), res.getInt("nbTelechargement"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}
	
	
	public void BecomePremium (Client client) throws SQLException, ClassNotFoundException{
		try{
			String query = "UPDATE CompoClient SET idCategorieClient = 2 WHERE idClient =" + client.getId();
			Statement s = conn.createStatement();
			s.executeUpdate(query);
		} catch (Exception e) {}
	}
	public static void main (String[]argv) throws ClassNotFoundException, SQLException{
		DataBase db = new DataBase();
		
		if(db.verifpseudo("Kikoudu93")){
			System.out.println("ok");
		}else{
			System.out.println("ok");
		}
		List<Video> test=db.afficheVideo();
		for (int i =0; i<test.size();i++){
			System.out.println(test.get(i).getNomVideo());
		}
	}
}
