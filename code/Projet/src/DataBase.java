
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/** Explication 
 * 
 * @author Corentin Bouchaudon
 *
 */
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

	public Client connection(Client client) throws SQLException {// connecte le client grace a pseudo et mdp
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idClient, nomClient, prenomClient,email from Client where pseudo ='"
				+ client.getPseudo() + "' and mdp = '" + client.getMdp() + "'");
		if (res.next()) {
			client.setEmail(res.getString("email"));
			client.setId(res.getInt("idClient"));
			client.setNom(res.getString("nomClient"));
			client.setPrenon(res.getString("prenomClient"));
		}
		return client;
	}

	public Boolean verifpseudo(String pseudo) throws SQLException {// verifie si pseudo disponible
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select count(idClient) from Client where pseudo ='" + pseudo + "'");
		res.next();
		if (res.getInt(1) != 0) {
			return false;
		} else {
			return true;
		}
	}

	public Client inscription(Client client) throws SQLException {// inscrit et connecte le client

		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select max(idClient) from Client");
		if (res.next()) {
			client.setId(res.getInt(1) + 1);
		} else {
			client.setId(1);
		}
		int resultat = s
				.executeUpdate("insert into Client (idClient,nomClient, prenomClient, pseudo, mdp, email) values ("
						+ client.getId() + ",'" + client.getNom() + "','" + client.getPrenon() + "','"
						+ client.getPseudo() + "','" + client.getMdp() + "','" + client.getEmail() + "')");
		if (resultat == 1) {
			s.executeUpdate("insert into CompoClient values(" + client.getId() + ", 1)");
			return client;
		}
		return new Client();
	}

	public List<Video> afficheVideos() throws SQLException {// affiche les films du plus recent au plus ancien (dans la
															// bd)
		List<Video> videos = new ArrayList<>();
		Video video;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,nbddl,prixAchat,prixLocation from Video order by idVideo DESC");

		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"),res.getInt("nbddl"), res.getDouble("prixAchat"),
					res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;
	}

	public List<Video> suggestions(Video v, List<MotClef> mc) throws SQLException {//////////// a modifier pour plus de sugg
		List<Video> videos = new ArrayList<Video>();
		Statement s = conn.createStatement();
		Video video;
		Boolean ok = false;
		ResultSet res = s.executeQuery("select idVideo,nomVideo,groupeVideo,numEpisode,resume, nbVue,nbddl,prixAchat,prixLocation from Video where nomVideo ='"+v.getNomVideo()+"' and groupeVideo = '" +v.getGroupeVideo() + "' and numEpisode = "	+ (v.getNumepisode()+1));
		if(res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"),res.getInt("nbddl"), res.getDouble("prixAchat"),res.getDouble("prixLocation"));
			videos.add(video);
			ok =true;
		}
		List<Video> videosautres = new ArrayList<Video>();
		for (int i = 0 ; i<mc.size();i++) {
			String query;
			if(ok==true) {
				query ="select * from Video where idVideo in (select distinct (idVideo) from MotClefVideo where idMotClef="+mc.get(i).getId()+") and idVideo !="+videos.get(0).getId()+" and idVideo !="+v.getId();
			}else {
				query ="select * from Video where idVideo in (select distinct (idVideo) from MotClefVideo where idMotClef="+mc.get(i).getId()+")"+" and idVideo !="+v.getId();
			}
			System.out.println(query);
			res = s.executeQuery(query);
			while (res.next()) {
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"),res.getInt("nbddl"), res.getDouble("prixAchat"),
						res.getDouble("prixLocation"));

				videosautres.add(video);
			}
		}
		for (int j =0;j<videosautres.size();j++) {
			int compteur = 0;
			for (int k=j;k<videosautres.size();k++) {
				if(videosautres.get(j).getId()==videosautres.get(k).getId()) {
					compteur ++;
					System.out.println(videosautres.get(j).getNomVideo()+":"+compteur);
				}
			}
			if (compteur==mc.size()) {
				System.out.println("la");
				videos.add(videosautres.get(j));
			}

		}
		return videos;
	}

	public Video recupDernierID() throws SQLException {// recupere l'id de la derniere video
		String query = "SELECT max(idVideo) as idmax FROM Video";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		Video v = new Video();
		v.setId(res.getInt("idmax"));
		return v;
	}

	public List<Video> rechercheVideoMC(List<MotClef> mc) throws SQLException {// retourne les videos qui correspondent
																				// aux mots clefs
		List<Video> videos = new ArrayList<Video>();
		List<Video> videosreturn = new ArrayList<Video>();
		String query = "select  idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,nbddl,prixAchat,prixLocation from Video where idVideo in (select idVideo from MotClefVideo where idMotClef =";
		Statement s = conn.createStatement();
		ResultSet res;
		Video video;
		res = s.executeQuery(query + mc.get(0).getId() + ")");
		for (int i = 0; i < mc.size(); i++) {
			res = s.executeQuery(query + mc.get(i).getId() + ")");
			while (res.next()) {
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"),res.getInt("nbddl"),
						res.getDouble("prixAchat"), res.getDouble("prixLocation"));
				videos.add(video);
			}
		}
		for (int i = 0; i < videos.size(); i++) {
			int cpt = 0;
			for (int j = i; j < videos.size(); j++) {
				if (videos.get(i).getId() == videos.get(j).getId()) {
					cpt++;
				}
			}

			if (cpt == mc.size()) {
				videosreturn.add(videos.get(i));
			}
		}
		return videosreturn;
	}

	public List<MotClef> listMotClef() throws SQLException {// retourne les mots clef
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

	public Video incrementevue(Video v) throws SQLException {// increment les vues sur la video
		String query = "Update Video Set nbvue = nbvue+1 where idVideo =" + v.getId();
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			v.setNbvue(v.getNbvue() + 1);
		}
		return v;

	}
	public Video incrementeddl(Video v) throws SQLException {// increment les vues sur la video
		String query = "Update Video Set nbddl = nbddl+1 where idVideo =" + v.getId();
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			v.setNbvue(v.getNbvue() + 1);
		}
		return v;

	}

	public void becomePremium(Client client) throws SQLException, ClassNotFoundException {// transforme un inscrit en
																							// premium
		try {
			String query = "UPDATE CompoClient SET idCategorieClient = 2 WHERE idClient =" + client.getId();
			Statement s = conn.createStatement();
			s.executeUpdate(query);
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";
			Statement s2 = conn.createStatement();
			ResultSet res = s2.executeQuery(query);
			if (res.next()) {
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+100";
				s2.executeUpdate(query);
			} else {
				query = "select max(idCA) from ChiffreAffaire";
				res = s.executeQuery(query);
				if (res.next()) {
					query = "insert into ChiffreAffaire values (" + (res.getInt(1) + 1) + ",CURRENT_DATE,100)";
				} else {
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE',100)";
				}
				s.executeUpdate(query);
			}
		} catch (Exception e) {
		}
	}

	public CategorieClient categorieclient(Client c) throws SQLException { // retourn la categorie d'un client
		CategorieClient cc = new CategorieClient();
		String query = "select * from CategorieClient cc, CompoCLient ccl where cc.idCategorieClient= ccl.idCategorieClient and ccl.idClient ="
				+ c.getId();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		cc.setCategorie(res.getString(2));
		cc.setIdcategorie(res.getInt(1));
		return cc;

	}


	public List<Client> listpseudoclients() throws SQLException {// retourne la totalit� des pseudo
		List<Client> clients = new ArrayList<Client>();
		String query = "select pseudo from CLient";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			Client c = new Client(res.getString(1));
			clients.add(c);
		}
		return clients;
	}

	public List<CategorieClient> liststatus() throws SQLException {// retourne les categorie de tout les user
		List<CategorieClient> cate = new ArrayList<CategorieClient>();
		String query = "select nomCategorieClient from CategorieClient cc,CompoClient ccl where cc.idCategorieClient = ccl.idCategorieClient";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			CategorieClient c = new CategorieClient(res.getString(1));
			cate.add(c);
		}
		return cate;
	}

	public double afficheCA(Date date) throws SQLException {// affiche le CA apres date passer en param
		///////////WARNING////////////
		/////////// Pour avoir 2018 il faut passer en parametre 2018-1900
		/////////// Pour avoir Fevrier il faut passer en parametre 02-1
		double ca;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String datestring = df.format(date);
		String query = "select SUM(valeurCA) from ChiffreAffaire where dateCA >='" + datestring + "'";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		ca = res.getDouble(1);
		return ca;
	}

	public boolean ajoutVideo(Video video, CategorieVideo cate, List<MotClef> mc) throws SQLException {// avant	cette fonction appeler recupdernierid incrementer le res par 1 puis faire setID
		String query = "insert into video values (" + video.getId() + ",'" + video.getNomVideo() + "','"
				+ video.getGroupeVideo() + "'," + video.getNumepisode() + ",'" + video.getResume() + "',"
				+ video.getNbvue() + "," + video.getPrixAchat() + "," + video.getPrixLocation() + ")";
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			query = "insert into CompoVideo values (" + video.getId() + "," + cate.getId() + ")";
			res = s.executeUpdate(query);
			if (res == 1) {
				for (int i = 0; i < mc.size(); i++) {// pas encore tester cette partie la
					query = "insert into MotClefVideo values(" + video.getId() + "," + mc.get(i).getId() + ")";
					s.executeUpdate(query);
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;

		}
	}

	public boolean videoExiste(Video video) throws SQLException {// besoin de connaitre le nom le group et le num
																	// episode
		String query = "select count(*) from Video where nomVideo='" + video.getNomVideo() + "' and groupeVideo = '"
				+ video.getGroupeVideo() + "' and numEpisode =" + video.getNumepisode();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		if (res.getInt(1) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean suppVideo(Video video) throws SQLException {// supprime la video passer en param�tre
		String query = "Delete From CompoVideo where idVideo ='" + video.getId() + "'";
		String query2 = "Delete From Location where idVideo ='" + video.getId() + "'";
		String query3 = "Delete From Achat where idVideo ='" + video.getId() + "'";
		String query4 = "Delete From MotClefVideo where idVideo ='" + video.getId() + "'";
		Statement s = conn.createStatement();
		s.executeUpdate(query2);
		s.executeUpdate(query3);
		s.executeUpdate(query4);
		int res = s.executeUpdate(query);
		if (res == 1) {
			query = "Delete From Video where idVideo =" + video.getId();
			res = s.executeUpdate(query);
			if (res == 1) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public boolean suppClient(Client client) throws SQLException {// supprime le client passer en parametre
		String query = "Delete From CompoClient where idClient ='" + client.getId() + "'";
		String query2 = "Delete From Location where idClient ='" + client.getId() + "'";
		String query3 = "Delete From Achat where idClient ='" + client.getId() + "'";
		String query4 = "Delete From Client where idClient ='" + client.getId() + "'";
		Statement s = conn.createStatement();
		s.executeUpdate(query);
		s.executeUpdate(query2);
		s.executeUpdate(query3);
		int res = s.executeUpdate(query4);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean louer(Client c, Video v) throws SQLException {// creer une location

		String query = "insert into Location values (" + c.getId() + "," + v.getId()
				+ ", CURRENT_DATE, CURRENT_DATE+7)";
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		
		if (res == 1) {
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";
			ResultSet resbis = s.executeQuery(query);
			if (resbis.next()) {
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+"+v.getPrixLocation();
				s.executeUpdate(query);
			} else {
				query = "select max(idCA) from ChiffreAffaire";
				resbis = s.executeQuery(query);
				if (resbis.next()) {
					query = "insert into ChiffreAffaire values (" + (resbis.getInt(1) + 1) + ",CURRENT_DATE,"+v.getPrixLocation()+")";
				} else {
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE',"+v.getPrixLocation()+")";
				}
				s.executeUpdate(query);
			}
			return true;
		}else {
			return false;
		}
	}

	public boolean acheter(Client c, Video v) throws SQLException {// creer un Achat

		String query = "insert into Achat values (" + c.getId() + "," + v.getId() + ")";
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";
			ResultSet resbis = s.executeQuery(query);
			if (resbis.next()) {
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+"+v.getPrixAchat();
				s.executeUpdate(query);
			} else {
				query = "select max(idCA) from ChiffreAffaire";
				resbis = s.executeQuery(query);
				if (resbis.next()) {
					query = "insert into ChiffreAffaire values (" + (resbis.getInt(1) + 1) + ",CURRENT_DATE,"+v.getPrixAchat()+")";
				} else {
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE',"+v.getPrixAchat()+")";
				}
				s.executeUpdate(query);
			}
			return true;
		}else {
			return false;
		}
	}


	public List<Video> rechercheVideoCate(CategorieVideo cate) throws SQLException {// retourne les films appartenant �
																					// une certaine cat�gorie
		List<Video> videos = new ArrayList<Video>();
		Video v = new Video();
		String query = "select v.idVideo, nomVideo,groupevideo,numepisode,resume,nbvue,nbddl,prixAchat,prixLocation from Video v, CompoVideo cv where v.idVideo=cv.idVideo and cv.idCategorieVideo ="
				+ cate.getId();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8),res.getDouble(9));
			videos.add(v);
		}
		return videos;

	}

	public List<Video> afficheVideosansDoublon() throws SQLException {// affiche les films/Documentaire/Serie(sans
																		// doublon)
		List<Video> videos = new ArrayList<Video>();
		List<Video>videosreturn = new ArrayList<Video>();
		List<Integer>idvideos = new ArrayList<Integer>();
		Video v = new Video();
		String query = "select Distinct(nomVideo) from Video";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			videos.add(new Video(res.getString(1)));
		}
		for(int i=0;i<videos.size();i++) {
			query = "select min(idVideo) from video where nomVideo ='"+videos.get(i).getNomVideo()+"'";
			res = s.executeQuery(query);
			while(res.next()) {
				idvideos.add(res.getInt(1));
			}
		}
		Collections.sort(idvideos);
		for(int i=0;i<idvideos.size();i++) {
			query="select * from Video where idVideo ="+idvideos.get(i);
			res = s.executeQuery(query);
			res.next();
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videosreturn.add(v);
		}

		return videosreturn;

	}
	public Video retrouveridvianomnomgroupetnbepisode(Video v)throws SQLException{
		String query = "select idVideo from Video where nomVideo ='"+v.getNomVideo()+"' and groupeVideo ='"+v.getGroupeVideo()+"' and numEpisode = "+v.getNumepisode();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if(res.next()) {
			v.setId(res.getInt(1));
		}else {};//video pas dans bd
		return v;
	}


	public int listMembrepremium()throws SQLException{
		String query = "select count(*) from CompoClient where idCategorieClient = 2";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		return res.getInt(1);
	}

	public List<Video> locationsCouranteUser(Client c)throws SQLException{//retourne les locations actif d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Location where idCLient = "+c.getId()+" and datefin >= CURRENT_DATE)order by idVideo";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;
	}
	public List<Video> vieilleLocationsUser(Client c)throws SQLException{//retourne les vieilles location d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Location where idCLient = "+c.getId()+" and datefin < CURRENT_DATE) order by idVideo";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;
	}

	public List<Video> achatsUser(Client c)throws SQLException{// retourne les achats d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Achat where idCLient = "+c.getId()+")";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;
	}

	public List<MotClef> motClefvideo(Video v)throws SQLException{//retourne la list des mots clefs d'un video
		List<MotClef>mc =new ArrayList<MotClef>();
		String query = " select idMotClef from MotClefVideo where idVideo = "+v.getId();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while(res.next()) {
			MotClef m = new MotClef(res.getInt(1));
			mc.add(m);
		}
		return mc;

	}

	public Video searchVideoByID(int id)throws SQLException{// retourve une video par son id
		String query = "select * from Video where idVideo="+id;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		Video v;
		if(res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
		}else { v= new Video(); }

		return v;

	}
	
	public int IdBypseudo(String pseudo) throws SQLException {// retourne l id en fonction du pseudo
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idClient from Client where pseudo ='" + pseudo + "'");
		if (res.next()) {
			return res.getInt(1);
		} else {
			return -1;
		}
	}
	
	public boolean modifVideo(Video v)throws SQLException{//on peux pas modifier le nom, le groupe, le num d'episode � cause des
														  // suggestions, on ne peux pas modifier nbvue et nbddl car �a serait 
														  //de la fraude 
		
		String query = " Update Video SET resume ='"+v.getResume()+"' and prixlocation = "+v.getPrixLocation()+" and prixachat ="+v.getPrixAchat()+
				"where idVideo = "+v.getId();
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean modifClient(Client c)throws SQLException{//on peux tout changer sauf prenom et nom car on ne change pas de prenom
															//ou de nom
		
		String query = " Update Video SET pseudo ='"+c.getPseudo()+"' and mdp = "+c.getMdp()+" and email ="+c.getEmail()+
				"where idClient = "+c.getId();
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			return true;
		}else {
			return false;
		}
	}
	

	
	public static void main(String[] argv) throws ClassNotFoundException, SQLException {// permet de test fonction de la
																						// bd
		DataBase db = new DataBase();
		Video v = new Video (16,"Star Trek Discovery","1",1);
		List<MotClef> mc = db.motClefvideo(v);
		List<Video>videos =  db.suggestions(v, mc);
		for (int i = 0; i<videos.size();i++) {
			System.out.println(videos.get(i).getId()+"   "+videos.get(i).getNomVideo());
		}
		db.finalize();

	}


}
