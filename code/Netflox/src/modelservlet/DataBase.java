package modelservlet;

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

/**
 * Created by Corentin Bouchaudon
 */
public class DataBase {

	private Connection conn;

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DataBase() throws ClassNotFoundException, SQLException {// ouvre la connection vers la BD
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://tp-postgres:5432/cbouch3_a", "cbouch3_a", "cbouch3_a");// remettre
																													// tp-postgres
																													// �
																													// la
																													// fac
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() {
		try {
			if (conn != null && conn.isClosed())
				conn.close();
		} catch (Exception e) {
		}
	}

	/**
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public Client connection(Client client) throws SQLException {// connecte le client grace a pseudo et mdp
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select idClient, nomClient, prenomClient,email from Client where pseudo ='"
				+ client.getPseudo() + "' and mdp = '" + client.getMdp() + "' order by idClient");// retourne l'idee de
																									// la personne qu
																									// correspond au
		System.out.println("test");																						// pseudo et l'id
		if (res.next()) {// s'il existe renvoie les informations du client ainsi que son id
			client.setEmail(res.getString("email"));
			client.setId(res.getInt("idClient"));
			client.setNom(res.getString("nomClient"));
			client.setPrenon(res.getString("prenomClient"));
			String query ="select ccl.idClient from CategorieClient cc, compoClient ccl where ccl.idClient ="+client.getId()+" and cc.idCategorieClient = ccl.idCategorieClient and finPremium<Current_Date";
			res =s.executeQuery(query);
			if(res.next()) {
				if(res.getInt(1)==client.getId()) {
					query = "Update CompoCLient Set idcategorieclient = 1, finPremium=null where idClient="+client.getId();
					s.executeUpdate(query);
				}
			}
		} // sinon ne change rien
		return client;
	}

	/**
	 * @param pseudo
	 * @return
	 * @throws SQLException
	 */
	public Boolean verifpseudo(String pseudo) throws SQLException {// verifie si pseudo disponible
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select count(idClient) from Client where pseudo ='" + pseudo + "'");// retourne
																											// le nombre
																											// de ligne
																											// dont le
																											// pseudo
																											// correspond
																											// a celui
																											// envoye
		res.next();// recupere le resultat 1 ligne max
		if (res.getInt(1) != 0) {// s'il existe ou s'il y a erreur retour faux
			return false;
		} else {
			return true;// sinon retourne vrai
		}
	}


	/**
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public Client inscription(Client client) throws SQLException {// inscrit et connecte le client

		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select max(idClient) from Client");// retourne l'ide max de client
		if (res.next()) {// si il y a un resultat incremente l'id
			client.setId(res.getInt(1) + 1);
		} else {// sinon met l'id � 1
			client.setId(1);
		}
		// insert le client dans la base avec ces infos
		int resultat = s
				.executeUpdate("insert into Client (idClient,nomClient, prenomClient, pseudo, mdp, email) values ("
						+ client.getId() + ",'" + client.getNom() + "','" + client.getPrenon() + "','"
						+ client.getPseudo() + "','" + client.getMdp() + "','" + client.getEmail() + "')");
		if (resultat == 1) {// si l'insertion fonctionne ajoute le client dans compoclient
			s.executeUpdate("insert into CompoClient values(" + client.getId() + ", 1)");
			return client;// retourne le client creer
		}
		return new Client();// retourne un client pour dire qu'il n'y a pas eu d'inscription
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Video> afficheVideos() throws SQLException {// affiche les films du plus recent au plus ancien (dans la
															// bd)
		List<Video> videos = new ArrayList<>();
		Video video;
		Statement s = conn.createStatement();
		// retourne toute les videos de la BD
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,nbddl,prixAchat,prixLocation from Video order by idVideo DESC");
		// permet d'inserer les videos obtenues dans une liste de video
		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"), res.getInt("nbddl"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;// retourne la liste de videos
	}

	/**
	 * @param v
	 * @param mc
	 * @return
	 * @throws SQLException
	 */
	public List<Video> suggestions(Video v, List<MotClef> mc) throws SQLException {//////////// a modifier pour plus de
																					//////////// sugg
		List<Video> videos = new ArrayList<Video>();
		Statement s = conn.createStatement();
		Video video;
		Boolean ok = false;
		// permet si c'est une s�rie d'avoir l'episode suivant
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume, nbVue,nbddl,prixAchat,prixLocation from Video where nomVideo ='"
						+ v.getNomVideo() + "' and groupeVideo = '" + v.getGroupeVideo() + "' and numEpisode = "
						+ (v.getNumepisode() + 1));
		if (res.next()) {// on ajoute l'episode suivant � la liste s'il existe
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"), res.getInt("nbddl"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
			ok = true;// permet de savoir ensuite si on a trouver l'episode suivant
		}
		// permet d'ajouter aux suggestions des videos ayants des mots clef similaire
		List<Video> videosautres = new ArrayList<Video>();
		for (int i = 0; i < mc.size(); i++) {
			String query;
			if (ok == true) {// si on a deja un episode suivant
				query = "select * from Video where idVideo in (select distinct (idVideo) from MotClefVideo where idMotClef="
						+ mc.get(i).getId() + ") and idVideo !=" + videos.get(0).getId() + " and idVideo !="
						+ v.getId();
			} else {// sinon
				query = "select * from Video where idVideo in (select distinct (idVideo) from MotClefVideo where idMotClef="
						+ mc.get(i).getId() + ")" + " and idVideo !=" + v.getId();
			}
			res = s.executeQuery(query);
			while (res.next()) {// met tout les episodes qui ont des mots clefs en commun avec notre video /
								// risque de doublon
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"), res.getInt("nbddl"),
						res.getDouble("prixAchat"), res.getDouble("prixLocation"));

				videosautres.add(video);
			}
		}
		// double boucle pour enlever les doublons
		for (int j = 0; j < videosautres.size(); j++) {
			int compteur = 0;
			for (int k = j; k < videosautres.size(); k++) {
				if (videosautres.get(j).getId() == videosautres.get(k).getId()) {
					compteur++;
				}
			}
			if (compteur == mc.size()) {// retourne que les videos qui ont les memes mots clef
				videos.add(videosautres.get(j));
			}

		}
		return videos;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public Video recupDernierID() throws SQLException {// recupere l'id de la derniere video
		String query = "SELECT max(idVideo) as idmax FROM Video";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		Video v = new Video();
		v.setId(res.getInt("idmax"));
		return v;
	}

	/**
	 * @param mc
	 * @return
	 * @throws SQLException
	 */
	public List<Video> rechercheVideoMC(List<MotClef> mc) throws SQLException {// retourne les videos qui correspondent
																				// aux mots clefs
		List<Video> videos = new ArrayList<Video>();
		List<Video> videosreturn = new ArrayList<Video>();
		String query = "select  idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,nbddl,prixAchat,prixLocation from Video where idVideo in (select idVideo from MotClefVideo where idMotClef =";
		Statement s = conn.createStatement();
		ResultSet res;
		Video video;
		for (int i = 0; i < mc.size(); i++) {// permet de retourner chaque video qui possede un mot clef en commun
												// risque de doublon
			res = s.executeQuery(query + mc.get(i).getId() + ")order by idVideo");
			while (res.next()) {
				video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
						res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"), res.getInt("nbddl"),
						res.getDouble("prixAchat"), res.getDouble("prixLocation"));
				videos.add(video);
			}
		} // enleve les doublons
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

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<MotClef> listMotClef() throws SQLException {// retourne les mots clef
		String query = "select * from MotClef";// retourne tout les mots clef de la base
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		List<MotClef> motclefs = new ArrayList<MotClef>();
		MotClef mc;
		while (res.next()) {
			mc = new MotClef(res.getInt(1), res.getString(2));
			motclefs.add(mc);
		}
		return motclefs;
	}

	/**
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public Video incrementevue(Video v) throws SQLException {// increment les vues sur la video
		String query = "Update Video Set nbvue = nbvue+1 where idVideo =" + v.getId();// incremente de 1 le nombre de
																						// vue de la video
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			v.setNbvue(v.getNbvue() + 1);
		}
		return v;

	}

	/**
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public Video incrementeddl(Video v) throws SQLException {// incremente les vues sur la video
		String query = "Update Video Set nbddl = nbddl+1 where idVideo =" + v.getId();// incremente de 1 le nombre de
																						// telechargement de la video
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			v.setNbddl(v.getNbddl() + 1);
		}
		return v;

	}

	/**
	 * @param client
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void becomePremium(Client client) throws SQLException, ClassNotFoundException {// transforme un inscrit en
																							// premium
		try {
			String query = "UPDATE CompoClient SET idCategorieClient = 2, finPremium = CURRENT_DATE+30 WHERE idClient =" + client.getId();// update la
																											// categorie
																											// du client
			Statement s = conn.createStatement();
			s.executeUpdate(query);
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";// recupere le CA du jour
			Statement s2 = conn.createStatement();
			ResultSet res = s2.executeQuery(query);
			if (res.next()) {// s'il existe alors incremente de 100e le CA
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+100";
				s2.executeUpdate(query);
			} else {// sinon cree un nouveau CA
				query = "select max(idCA) from ChiffreAffaire";// recupere CAmax
				res = s.executeQuery(query);
				if (res.next()) {
					query = "insert into ChiffreAffaire values (" + (res.getInt(1) + 1) + ",CURRENT_DATE,100)";// si il
																												// y a
																												// deja
																												// des
																												// CA
				} else {
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE',100)";// si c'est le premier CA
				}
				s.executeUpdate(query);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public CategorieClient categorieclient(Client c) throws SQLException { // retourn la categorie d'un client
		CategorieClient cc = new CategorieClient();
		String query = "select cc.idcategorieClient, cc.nomCategorieClient, ccl.finPremium from CategorieClient cc, CompoCLient ccl where cc.idCategorieClient= ccl.idCategorieClient and ccl.idClient ="
				+ c.getId();// retourne la cate du client
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		cc.setCategorie(res.getString(2));
		cc.setIdcategorie(res.getInt(1));
		cc.setFinPremium(res.getDate(3));
		return cc;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Client> listpseudoclients() throws SQLException {// retourne la totalit� des pseudo
		List<Client> clients = new ArrayList<Client>();
		String query = "select idClient, pseudo from Client order by idClient";// retourne tout les pseudos de la BD
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			Client c = new Client(res.getString(2));
			clients.add(c);
		}
		return clients;// retourne des clients ayant comme seul valeur leur pseudo
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<CategorieClient> liststatus() throws SQLException {// retourne les categorie de tout les user
		List<CategorieClient> cate = new ArrayList<CategorieClient>();
		String query = "select nomCategorieClient from CategorieClient cc,CompoClient ccl where cc.idCategorieClient = ccl.idCategorieClient";// retourne
																																				// pour
																																				// tout
																																				// les
																																				// users
																																				// leur
																																				// categorie;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			CategorieClient c = new CategorieClient(res.getString(1));
			cate.add(c);
		}
		return cate;// retourne un liste de categorie de client
	}

	/**
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public double afficheCA(Date date) throws SQLException {// affiche le CA apres date passer en param
		/////////// WARNING////////////
		/////////// Pour avoir 2018 il faut passer en parametre 2018-1900
		/////////// Pour avoir Fevrier il faut passer en parametre 02-1
		double ca;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String datestring = df.format(date);
		String query = "select SUM(valeurCA) from ChiffreAffaire where dateCA >='" + datestring + "'";// affiche la
																										// valeur du CA
																										// fait depuis
																										// date
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		ca = res.getDouble(1);
		return ca;
	}

	/**
	 * @param video
	 * @param cate
	 * @param mc
	 * @return
	 * @throws SQLException
	 */
	public boolean ajoutVideo(Video video, CategorieVideo cate, List<MotClef> mc) throws SQLException {// avant cette
																										// fonction
																										// appeler
																										// recupdernierid
																										// incrementer
																										// le res par 1
																										// puis faire
																										// setID
		String query = "insert into video values (" + video.getId() + ",'" + video.getNomVideo() + "','"
				+ video.getGroupeVideo() + "'," + video.getNumepisode() + ",'" + video.getResume() + "',"
				+ video.getNbvue() + "," + video.getNbddl() + "," + video.getPrixAchat() + "," + video.getPrixLocation()
				+ ")";// creer une video
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {// si la video a �t� inser� dans la BD
			query = "insert into CompoVideo values (" + video.getId() + "," + cate.getId() + ")";// on ajoute sa
																									// categorie
			res = s.executeUpdate(query);
			if (res == 1) {
				for (int i = 0; i < mc.size(); i++) {
					query = "insert into MotClefVideo values(" + video.getId() + "," + mc.get(i).getId() + ")";// on
																												// ajoute
																												// ses
																												// mots
																												// clefs
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

	/**
	 * @param video
	 * @return
	 * @throws SQLException
	 */
	public boolean videoExiste(Video video) throws SQLException {// besoin de connaitre le nom le group et le num
																	// episode
		String query = "select count(*) from Video where nomVideo='" + video.getNomVideo() + "' and groupeVideo = '"
				+ video.getGroupeVideo() + "' and numEpisode =" + video.getNumepisode();// retourne la video si elle
																						// existe
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		if (res.getInt(1) == 0) {
			return false;// retourne faux si elle n'existe pas
		} else {
			return true;// retourne vrai sinon
		}
	}

	/**
	 * @param video
	 * @return
	 * @throws SQLException
	 */
	public boolean suppVideo(Video video) throws SQLException {// supprime la video passer en param�tre
		String query = "Delete From CompoVideo where idVideo ='" + video.getId() + "'";// supprime la video dans
																						// compovideo
		String query2 = "Delete From Location where idVideo ='" + video.getId() + "'";// supprime la video dans Location
		String query3 = "Delete From Achat where idVideo ='" + video.getId() + "'";// supprime la video dans Achat
		String query4 = "Delete From MotClefVideo where idVideo ='" + video.getId() + "'";// supprime la video dans
																							// MotCLef
		Statement s = conn.createStatement();
		// manque de temps pur verifier si tout fonctionne bien
		s.executeUpdate(query2);
		s.executeUpdate(query3);
		s.executeUpdate(query4);
		int res = s.executeUpdate(query);
		if (res == 1) {// si tout ce passe bien supprime la video dans video;
			query = "Delete From Video where idVideo =" + video.getId();
			res = s.executeUpdate(query);
			if (res == 1) {// si la suppression se passe bien retourne vrai
				return true;
			} else {
				return false;// Sinon retourne faux
			}
		}
		return false;

	}

	/**
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public boolean suppClient(Client client) throws SQLException {// supprime le client passer en parametre
		String query = "Delete From CompoClient where idClient =" + client.getId();// supprime la ligne dans compoCLient
		String query2 = "Delete From Location where idClient =" + client.getId();// supprime la ligne dans Location
		String query3 = "Delete From Achat where idClient =" + client.getId();// supprime la ligne dans Achat
		String query4 = "Delete From Client where idClient =" + client.getId();// supprime la ligne dans Client
		Statement s = conn.createStatement();
		// manque de temps pur verifier si tout fonctionne bien
		s.executeUpdate(query);
		s.executeUpdate(query2);
		s.executeUpdate(query3);
		int res = s.executeUpdate(query4);
		if (res == 1) {// si tout ce passe bien retorune vrai
			return true;
		} else {
			return false;// Sinon retourne faux
		}
	}

	/**
	 * @param c
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public boolean louer(Client c, Video v) throws SQLException {// creer une location

		String query = "insert into Location values (" + c.getId() + "," + v.getId()
				+ ", CURRENT_DATE, CURRENT_DATE+7)";// insert une Location de 7jours
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);

		if (res == 1) {
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";// recupere id CA
			ResultSet resbis = s.executeQuery(query);
			if (resbis.next()) {// si ca existe
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+" + v.getPrixLocation() + " where idCA ="
						+ resbis.getInt(1);// augmente le CA d'aujourd'hui
				s.executeUpdate(query);
			} else {
				query = "select max(idCA) from ChiffreAffaire";// retourne le plus grand CA
				resbis = s.executeQuery(query);
				if (resbis.next()) {// si CA existe incremente de 1 et creer un CA
					query = "insert into ChiffreAffaire values (" + (resbis.getInt(1) + 1) + ",CURRENT_DATE,"
							+ v.getPrixLocation() + ")";
				} else {// sinon creer le premier CA
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE'," + v.getPrixLocation() + ")";
				}
				s.executeUpdate(query);
			}
			if(v.getPrixLocation()==0){
				query = " Update Parrain set nbVideo =nbVideo -1 where idParrain ="+c.getId();
				s.executeUpdate(query);
			}
			return true;// si ok retourne true
		} else {
			return false;// sinon retourne faux
		}
	}

	/**
	 * @param c
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public boolean acheter(Client c, Video v) throws SQLException {// creer un Achat

		String query = "insert into Achat values (" + c.getId() + "," + v.getId() + ")";// insertion de l'achat
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			query = "select idCA from ChiffreAffaire where dateCA =CURRENT_DATE";// recupere id CA
			ResultSet resbis = s.executeQuery(query);
			if (resbis.next()) {
				query = "Update ChiffreAffaire SET valeurCA = valeurCA+" + v.getPrixAchat();// retourne le plus grand CA
				s.executeUpdate(query);
			} else {
				query = "select max(idCA) from ChiffreAffaire";// retourne le plus grand CA
				resbis = s.executeQuery(query);
				if (resbis.next()) {// si CA existe incremente de 1 et creer un CA
					query = "insert into ChiffreAffaire values (" + (resbis.getInt(1) + 1) + ",CURRENT_DATE,"
							+ v.getPrixAchat() + ")";
				} else {// sinon creer le premier CA
					query = "insert into ChiffreAffaire values (" + 1 + ",'CURRENT_DATE'," + v.getPrixAchat() + ")";
				}
				s.executeUpdate(query);
			}
			return true;// si ok retourne true
		} else {
			return false;// sinon retourne faux
		}
	}

	/**
	 * @param cate
	 * @return
	 * @throws SQLException
	 */
	public List<Video> rechercheVideoCate(CategorieVideo cate) throws SQLException {// retourne les films appartenant
																					// �
																					// une certaine cat�gorie
		List<Video> videos = new ArrayList<Video>();
		Video v = new Video();
		String query = "select v.idVideo, nomVideo,groupevideo,numepisode,resume,nbvue,nbddl,prixAchat,prixLocation from Video v, CompoVideo cv where v.idVideo=cv.idVideo and cv.idCategorieVideo ="
				+ cate.getId();// retourne toute les videos qui corresponde � la categorie
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}
		return videos;

	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Video> afficheVideosansDoublon() throws SQLException {// affiche les films/Documentaire/Serie(sans
																		// doublon)
		List<Video> videos = new ArrayList<Video>();
		List<Video> videosreturn = new ArrayList<Video>();
		List<Integer> idvideos = new ArrayList<Integer>();
		Video v = new Video();
		String query = "select Distinct(nomVideo) from Video";// retourne tout les noms de videos en enlevant les
																// doublons
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			videos.add(new Video(res.getString(1)));// on les ajoute dans videos
		}
		for (int i = 0; i < videos.size(); i++) {
			query = "select min(idVideo) from video where nomVideo ='" + videos.get(i).getNomVideo() + "'";// por toute
																											// les
																											// videos de
																											// videos on
																											// retourne
																											// leur id
			res = s.executeQuery(query);
			while (res.next()) {
				idvideos.add(res.getInt(1));// inserer dans un tableau d'entier
			}
		}
		Collections.sort(idvideos);// on trie les id par ordre croissant
		for (int i = 0; i < idvideos.size(); i++) {// pour toute les id ont recupere les infos de la video
			query = "select * from Video where idVideo =" + idvideos.get(i);
			res = s.executeQuery(query);
			res.next();
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videosreturn.add(v);
		}

		return videosreturn;// on retourne la liste de video

	}

	/**
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public Video retrouveridvianomnomgroupetnbepisode(Video v) throws SQLException {
		String query = "select idVideo from Video where nomVideo ='" + v.getNomVideo() + "' and groupeVideo ='"
				+ v.getGroupeVideo() + "' and numEpisode = " + v.getNumepisode();// recupere l'id de la video
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if (res.next()) {
			v.setId(res.getInt(1));// on donne la valeur de l'id de la video
		} else {
		}
		;// video pas dans bd
		return v;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public int listMembrepremium() throws SQLException {
		String query = "select count(*) from CompoClient where idCategorieClient = 2";// retourne le nombre de premium
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		return res.getInt(1);
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public List<Video> locationsCouranteUser(Client c) throws SQLException {// retourne les locations actif d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Location where idCLient = "
				+ c.getId() + " and datefin >= CURRENT_DATE)order by idVideo";// retourne les locations du clietn qui
																				// sont encore valide
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;// retournent les videos actuellement louer
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public List<Video> vieilleLocationsUser(Client c) throws SQLException {// retourne les vieilles location d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Location where idCLient = "
				+ c.getId() + " and datefin < CURRENT_DATE) order by idVideo";// retourne les locations du clietn qui ne
																				// sont plus valide
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;// retourne les vieilles location
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public List<Video> achatsUser(Client c) throws SQLException {// retourne les achats d'un user
		List<Video> videos = new ArrayList<Video>();
		Video v;
		String query = "select * from video where idVideo in (select idVideo from Achat where idCLient = " + c.getId()
				+ ")order by idVideo";// retourne les achats du client
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
			videos.add(v);
		}

		return videos;
	}

	/**
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public List<MotClef> motClefvideo(Video v) throws SQLException {// retourne la list des mots clefs d'un video
		List<MotClef> mc = new ArrayList<MotClef>();
		String query = " select idMotClef from MotClefVideo where idVideo = " + v.getId();// retourne les mots clefs de
																							// la video
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		while (res.next()) {
			MotClef m = new MotClef(res.getInt(1));
			mc.add(m);
		}
		return mc;// retourne les mots clefs de la video

	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Video searchVideoByID(int id) throws SQLException {
		String query = "select * from Video where idVideo=" + id;// retourne les infos de la video
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		Video v;
		if (res.next()) {
			v = new Video(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5),
					res.getInt(6), res.getInt(7), res.getDouble(8), res.getDouble(9));
		} else {
			v = new Video();
		}

		return v;

	}

	/**
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public boolean modifVideo(Video v) throws SQLException {// on peux pas modifier le nom, le groupe, le num d'episode
															// � cause des
															// suggestions, on ne peux pas modifier nbvue et nbddl car
															// �a serait
															// de la fraude

		String query = " Update Video SET resume ='" + v.getResume() + "' , prixlocation = " + v.getPrixLocation()
				+ " , prixachat =" + v.getPrixAchat() + " where idVideo = " + v.getId();// modifie les param�tres
																						// modifiables de la video c'est
																						// � dire le resume et les
																						// prix
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			return true;// si update fonctionne alors retourne vrai
		} else {
			return false;// sinon retourne faux
		}
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean modifClient(Client c) throws SQLException {// on peux tout changer sauf prenom et nom car on ne
																// change pas de prenom
																// ou de nom

		String query = " Update Client SET pseudo ='" + c.getPseudo() + "' , mdp = '" + c.getMdp() + "' , email ='"
				+ c.getEmail() + "' where idClient = " + c.getId();// modifie les param�tres modifiable d'un client on
																	// part du principe qu'il peux pas changer de nom et
																	// prenom
		Statement s = conn.createStatement();
		int res = s.executeUpdate(query);
		if (res == 1) {
			return true;// si update fonctionne alors retourne vrai
		} else {
			return false;// sinon retourne faux
		}
	}

	/**
	 * @param pseudo
	 * @return
	 * @throws SQLException
	 */
	public int idByPseudo(String pseudo) throws SQLException {
		String query = " select idClient from client where pseudo ='" + pseudo + "'";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if (res.next()) {
			return res.getInt("idClient");
		} else {
			return 0;
		}

	}
	/**
	 * @param id
	 * @return pseudo
	 * @throws SQLException
	 */
	public String pseudoById(int id) throws SQLException {
		String query = " select pseudo from client where idClient ='" + id + "'";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if (res.next()) {
			return res.getString(1);
		} else {
			return null;
		}

	}

	/**
	 * @param c
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public boolean isBuy(Client c, Video v) throws SQLException {
		String query = " select count(*) from  Achat where idClient=" + c.getId() + " and idVideo = " + v.getId();
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		if (res.getInt(1) >= 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param c
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public boolean isRent(Client c, Video v) throws SQLException {
		String query = " select count(*) from  Location where idClient=" + c.getId() + " and idVideo = " + v.getId()
				+ " and dateFin >= CURRENT_DATE";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		System.out.println(res.getInt(1));
		if (res.getInt(1) == 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param video
	 * @param cate
	 * @return
	 * @throws SQLException
	 */
	public List<Video> sontdansCategorie(List<Video> video, CategorieVideo cate) throws SQLException {

		String query = "Select count (*) from CompoVideo where idCategorieVideo = " + cate.getId() + " and idVideo = ";
		Statement s = conn.createStatement();
		ResultSet res;
		List<Video> videoreturn = new ArrayList<Video>();
		for (int i = 0; i < video.size(); i++) {
			res = s.executeQuery(query + video.get(i).getId());
			res.next();
			if (res.getInt(1) >= 1) {
				videoreturn.add(video.get(i));
			}
		}
		return videoreturn;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Video> afficheVideoscroissant() throws SQLException {// affiche les films dans l'ordre darriver dans la bd
		List<Video> videos = new ArrayList<>();
		Video video;
		Statement s = conn.createStatement();
		// retourne toute les videos de la BD
		ResultSet res = s.executeQuery(
				"select idVideo,nomVideo,groupeVideo,numEpisode,resume,nbVue,nbddl,prixAchat,prixLocation from Video order by idVideo ");
		// permet d'inserer les videos obtenues dans une liste de video
		while (res.next()) {
			video = new Video(res.getInt("idVideo"), res.getString("nomVideo"), res.getString("groupeVideo"),
					res.getInt("numEpisode"), res.getString("resume"), res.getInt("nbvue"), res.getInt("nbddl"),
					res.getDouble("prixAchat"), res.getDouble("prixLocation"));
			videos.add(video);
		}

		return videos;// retourne la liste de videos
	}
	/**
	 * @param pseudo
	 * @return
	 * @throws SQLException
	 */
	public Client infobypseudo(String pseudo) throws SQLException {// affiche les films du plus recent au plus ancien (dans la
		String query = "select nomClient,prenomCLient,email from client where pseudo ='"+pseudo+"'";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		Client c = new Client();
		if (res.next()) {
			c.setEmail(res.getString(3));
			c.setNom(res.getString(1));
			c.setPseudo(pseudo);
			c.setPrenon(res.getString(2));
		}
		return c;
	}
	
	
	/* Retourne vrai s'il est parrain*/
	/**
	 * @param idparrain
	 * @return
	 * @throws SQLException
	 */
	public Boolean isParrain(int idparrain) throws SQLException { //tu peux recuperer l'id avec idbypseudo
		String query = " select count(*) from parrain where idparrain = "+idparrain;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if(res.next()) {
			if(res.getInt(1)==0) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
		
	}
	/* retourne vrai si il est neveu */
	/**
	 * @param idneveu
	 * @return
	 * @throws SQLException
	 */
	public Boolean isNeveu(int idneveu) throws SQLException { //tu peux recuperer l'id avec idbypseudo
		String query = " select count(*) from parrain where idneveu = "+idneveu;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		if(res.next()) {
			if(res.getInt(1)==0) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
		
	}
	/**
	 * @param idNeveu
	 * @return
	 * @throws SQLException
	 */
	public Client getParrain(int idNeveu)throws SQLException{
		String query = "select idClient,nomClient,prenomClient,pseudo,email from Client where idClient in (select idParrain from parrain where idNeveu ="+idNeveu+")";
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		Client c= new Client();
		if (res.next()){
			c.setId(res.getInt(1));
			c.setNom(res.getString(2));
			c.setPrenon(res.getString(3));
			c.setPseudo(res.getString(4));
			c.setEmail(res.getString(5));
		}
		return c;
	}
	
	/**
	 * @param idParrain
	 * @param idNeveu
	 * @throws SQLException
	 */
	public void becomeNeveu(int idParrain, int idNeveu) throws SQLException {//utiliser uniquement si parrain n'a pas deja de neveau
		String query = " insert into parrain values("+idParrain+", "+idNeveu+",0,0)";
		Statement s = conn.createStatement();
		s.executeUpdate(query);
	}
	
	/**
	 * @param idClient
	 * @throws SQLException
	 */
	public void ajoutPoint(int idClient)throws SQLException{
		String query = "Update Parrain set nbPoints =nbPoints+1 where idNeveu ="+idClient;
		Statement s = conn.createStatement();
		s.executeUpdate(query);
		
		query = "select idParrain from parrain where idNeveu ="+idClient;
		ResultSet res = s.executeQuery(query);
		res.next();
		int idParrain=res.getInt(1);
		
		query = "select nbPoints from parrain where idNeveu ="+idClient;
		res = s.executeQuery(query);
		
		res.next();
		if (res.getInt(1)%50 == 0){
			query ="Update Parrain set nbPoints = 0 ,nbVideo = nbVideo+1  where idNeveu ="+idClient;
			s.executeUpdate(query);
			query="select finPremium from compoClient where idClient ="+idParrain;
			res = s.executeQuery(query);
			res.next();
			if(res.getDate(1)==null){
				query = " Update CompoClient set idCategorieClient = 2, finPremium = Current_Date + 30 where idClient="+idParrain;
				s.executeUpdate(query);
			}else{
				query = " Update CompoClient set idCategorieClient = 2, finPremium = finPremium + 30 where idClient="+idParrain;
				s.executeUpdate(query);
			}
		}else if(res.getInt(1)%10==0){
			query ="Update Parrain set nbVideo = nbVideo +1 where idNeveu ="+idClient;
			s.executeUpdate(query);
		}
		
	}
	/**
	 * @param idClient
	 * @return
	 * @throws SQLException
	 */
	public int nbPoint(int idClient)throws SQLException{//verifier si c'est un parrain avant
		String query ="select nbPoints from Parrain where idParrain ="+idClient; 
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		return res.getInt(1);	
	}
	
	/**
	 * @param idClient
	 * @return
	 * @throws SQLException
	 */
	public int nbVideo(int idClient)throws SQLException{//verifier si c'est un parrain avant
		String query ="select nbVideo from Parrain where idParrain ="+idClient; 
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		return res.getInt(1);	
	}
	
	/**
	 * @param idClient
	 * @return
	 * @throws SQLException
	 */
	public Date  dateFinPremium(int idClient)throws SQLException{
		String query ="select finPremium from CompoClient where idClient ="+idClient;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);
		res.next();
		return res.getDate(1);
	}
	


	/**
	 * @param idParrain
	 * @return
	 * @throws SQLException
	 */
	public String getIdNeveu(int idParrain)throws SQLException {
			String query =" select pseudo from Client where idClient in (select idNeveu from parrain where idParrain = "+idParrain+")";
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(query);		
			res.next();
			return (res.getString(1));
		}
	
	/**
	 * @param idClient
	 * @return
	 * @throws SQLException
	 */
	public Parrain getInfoParrain(int idClient)throws SQLException {
		String query =" select idNeveu,nbPoints, nbvideo from parrain where idParrain = "+idClient;
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(query);	
		Parrain p = new Parrain();
		if(res.next()) {
			p.setIdNeveu(res.getInt(1));
			p.setNbpoints(res.getInt(2));
			p.setNbvideo(res.getInt(3));
		}
		
		return p;
		
	}


}
