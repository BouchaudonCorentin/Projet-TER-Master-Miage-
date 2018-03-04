package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelservlet.CategorieVideo;
import modelservlet.Client;
import modelservlet.DataBase;
import modelservlet.MotClef;
import modelservlet.Video;

public class DataBaseTest {
	
	DataBase db;
	@Before
	public  void setUpBeforeClass() throws Exception {
		db = new DataBase();
	}

	@Test
	public void testConnection() throws SQLException {
		assertTrue(db.connection(new Client("Link91","kikou91")).getId()==1);
		assertTrue(db.connection(new Client("Link92","kikou91")).getId()==0);
		assertTrue(db.connection(new Client("Link92","kikou92")).getId()==0);
	}

	@Test
	public void testVerifpseudo() throws SQLException {
		assertTrue(db.verifpseudo("Link91")==false);
		assertTrue(db.verifpseudo("Link92")==true);
	}

	/*@Test
	public void testInscription() throws SQLException {
		assertTrue(db.inscription(new Client("Lenormand","Brian","Link92","kikou91","brian.lenormand@u-psud.fr")).getId()==4);
	}*/

	@Test
	public void testAfficheVideos() throws SQLException {
		assertTrue(db.afficheVideos().get(0).getId()==db.afficheVideos().size());
	}

	@Test
	public void testSuggestions()throws SQLException {
		List<MotClef>mc= new ArrayList();
		mc.add(new MotClef(1));
		mc.add(new MotClef(2));
		mc.add(new MotClef(3));
		assertTrue(db.suggestions(new Video(1,"Star Wars La Menace Fantome","",1,"Avant de devenir un célèbre chevalier Jedi, et bien avant de se révéler l âme la plus noire de la galaxie, Anakin Skywalker est un jeune esclave sur la planète Tatooine. La Force est déjà puissante en lui et il est un remarquable pilote de Podracer. Le maître Jedi Qui-Gon Jinn le découvre et entrevoit alors son immense potentiel.Pendant ce temps, l armée de droïdes de l insatiable Fédération du Commerce a envahi Naboo, une planète pacifique, dans le cadre d n plan secret des Sith visant à accroître leur pouvoir. Pour défendre la reine de Naboo, Amidala, les chevaliers Jedi vont devoir affronter le redoutable Seigneur Sith, Dark Maul.",666,100, 3.99,5.99),mc).get(0).getId()==2);
		mc= new ArrayList();
		mc.add(new MotClef(3));
		mc.add(new MotClef(9));
		mc.add(new MotClef(11));
		assertTrue(db.suggestions(new Video(74,"Black Mirror","4",1,"Chaque épisode de cette anthologie montre la dépendance des hommes vis-à-vis de tout ce qui a un écran...",250,100, 2.99,3.99),mc).get(0).getId()==75);
	}

	@Test
	public void testRecupDernierID() throws SQLException {
		assertTrue(db.recupDernierID().getId()==100);
	}

	@Test
	public void testRechercheVideoMC() throws SQLException {
		List<MotClef> mc = new ArrayList<MotClef>();
		mc.add(new MotClef(1));
		mc.add(new MotClef(2));
		mc.add(new MotClef(3));
		assertTrue(db.rechercheVideoMC(mc).get(0).getId()==1);
	}

	@Test
	public void testListMotClef() throws SQLException {
		assertTrue(db.listMotClef().get(0).getMotClef().equals("Aventure"));
		assertTrue(db.listMotClef().get(11).getMotClef().equals("Information"));
	}

	/*@Test
	public void testIncrementevue() throws SQLException {
		assertTrue(db.incrementevue(new Video(20,"Star Trek Discovery","1",5,"Après un siècle de silence, les klingons refont surface. Déterminés à réunifier leur empire, ils déclarent la guerre à la Fédération des planètes unies. Officier en disgrâce de la Starfleet, Michael Burnham se retrouve au centre du conflit.",200,100, 1.99,3.99)).getNbvue()==201);
	}

	@Test
	public void testIncrementeddl() throws SQLException {
		assertTrue(db.incrementeddl(new Video(20,"Star Trek Discovery","1",5,"Après un siècle de silence, les klingons refont surface. Déterminés à réunifier leur empire, ils déclarent la guerre à la Fédération des planètes unies. Officier en disgrâce de la Starfleet, Michael Burnham se retrouve au centre du conflit.",200,100, 1.99,3.99)).getNbddl()==101);
	}

	@Test
	public void testBecomePremium() throws ClassNotFoundException, SQLException {
		db.becomePremium(new Client(1));
		assertTrue(db.listMembrepremium()==2);
	}*/

	@Test
	public void testCategorieclient() throws SQLException {
		assertTrue(db.categorieclient(new Client(3)).getCategorie().equals("administrateur"));
	}

	@Test
	public void testListpseudoclients() throws SQLException {
		assertTrue(db.listpseudoclients().get(0).getPseudo().equals("Link91"));
	}

	@Test
	public void testListstatus() throws SQLException {
		assertTrue(db.liststatus().get(1).getCategorie().equals("premium"));
	}

	@Test
	public void testAfficheCA() throws SQLException {
		Date date =new Date(118,01,29);
		assertTrue(Math.round(db.afficheCA(date))==36);
	}

	/*@Test
	public void testAjoutVideo() throws SQLException {
		Video video = new Video("L homme sur Mars","",0,"A première vue, Loretta est une femme polynésienne comme beaucoup d autres. Sa maison, les courses au magasin, le jardin, les chiens accaparent une partie de son temps. Mais une toute petite partie seulement, car vous la trouverez plus souvent une gaffe, des hameçons ou un couteau à la main, vêtue d un gros ciré et de bottes en caoutchouc plutôt que d un pareo et d escarpins, pataugeant dans l eau salé, le sang de poissons du large ou la glace pilée. Partons à la rencontre de Loretta, la seule femme polynésienne embarquée sur un palangrier et qui fait mentir la sacro-sainte règle de tout marin pêcheur : «Pas de femme à bord !»",100,100, 3.99,8.99);
		List<MotClef>mc = new ArrayList<MotClef>();
		mc.add(new MotClef(1));
		assertTrue(db.ajoutVideo(video, new CategorieVideo(3) , mc)==true);
	}*/

	@Test
	public void testVideoExiste() throws SQLException {
		assertTrue(db.videoExiste(new Video("Black Mirror","4",6))==true);
		assertTrue(db.videoExiste(new Video("White Mirror","4",6))==false);
	}

	/*@Test
	public void testSuppVideo() throws SQLException {
		assertTrue(db.suppVideo(new Video(1))==true);
		assertTrue(db.suppVideo(new Video(1))==false);
		assertTrue(db.videoExiste(new Video("Star Wars La Menace Fantome","",1))==false);
	}

	@Test
	public void testSuppClient() throws SQLException {
		assertTrue(db.idByPseudo("Link91")==1);
		assertTrue(db.suppClient(new Client(1))==true);
		assertTrue(db.suppClient(new Client(1))==false);
		assertTrue(db.idByPseudo("Link91")==0);
	}
	
	@Test
	public void testLouer() throws SQLException {
		assertTrue(db.louer(new Client(1), new Video(87))==true);
	}

	@Test
	public void testAcheter() throws SQLException {
		assertTrue(db.louer(new Client(1), new Video(89))==true);
	}*/

	@Test
	public void testRechercheVideoCate() throws SQLException {
		CategorieVideo cv = new CategorieVideo(3);
		assertTrue(db.rechercheVideoCate(cv).get(0).getId()==97);
		assertFalse(db.rechercheVideoCate(cv).get(0).getId()==1);
	}

	@Test
	public void testAfficheVideosansDoublon() throws SQLException {
		assertTrue(db.afficheVideosansDoublon().get(17).getId()==39);
		assertFalse(db.afficheVideosansDoublon().get(17).getId()==17);
	}

	@Test
	public void testRetrouveridvianomnomgroupetnbepisode() throws SQLException {
		assertTrue(db.retrouveridvianomnomgroupetnbepisode(new Video("Star Trek Discovery","1",10)).getId()==25);
	}

	@Test
	public void testListMembrepremium() throws SQLException {
		assertTrue(db.listMembrepremium()==1);
		assertFalse(db.listMembrepremium()==100);
	}

	@Test
	public void testLocationsCouranteUser() throws SQLException {
		assertTrue(db.locationsCouranteUser(new Client(1)).get(0).getId()==31);
		assertFalse(db.locationsCouranteUser(new Client(1)).get(0).getId()==16);
	}

	@Test
	public void testVieilleLocationsUser() throws SQLException {
		assertTrue(db.vieilleLocationsUser(new Client(1)).get(0).getId()==16);
	}

	@Test
	public void testAchatsUser() throws SQLException {
		assertTrue(db.achatsUser(new Client(1)).get(0).getId()==1);
	}

	@Test
	public void testMotClefvideo() throws SQLException {
		assertTrue(db.motClefvideo(new Video(1)).get(0).getId()==1 && db.motClefvideo(new Video(33333)).size()==0);
		assertTrue(db.motClefvideo(new Video(1)).get(1).getId()==2);
	}

	@Test
	public void testSearchVideoByID() throws SQLException {
		assertTrue(db.searchVideoByID(1).getNomVideo().equals("Star Wars La Menace Fantome"));
		System.out.println(db.searchVideoByID(66666).getNomVideo());
		assertTrue(db.searchVideoByID(66666).getId()==0);
	}

	/*@Test
	public void testModifVideo() throws SQLException {
		Video v = new Video(1,"Star Wars La Menace Fantome","",1,"Coucou.",666,100, 8.99,9.99);
		db.modifVideo(v);
		System.out.println(db.afficheVideos().get(0).getResume());
		assertTrue(db.afficheVideosansDoublon().get(0).getResume().equals("Coucou."));
	}

	@Test
	public void testModifClient() throws SQLException {
		Client c1 = new Client("Link91","kikou91");
		Client c2 = new Client(1,"Lenormand","Brian","Link92","whereisbrian","brian.lenormand@u-psud.fr");
		assertTrue(db.modifClient(c2)==true);
		assertFalse(db.connection(c1).getId()==1);
	}*/

	@Test
	public void testIdByPseudo() throws SQLException {
		assertTrue(db.idByPseudo("Link91")==1);
		assertTrue(db.idByPseudo("Link92")==0);
		
	}

	@Test
	public void testIsBuy() throws SQLException {
		Client c = new Client(1);
		Video v1 = new Video(1);
		Video v2 = new Video(35);
		assertTrue(db.isBuy(c, v1)==true);
		assertTrue(db.isBuy(c, v2)==false);
		
	}

	@Test
	public void testIsRent() throws SQLException {
		Client c = new Client(1);
		Video v1 = new Video(1);
		Video v2 = new Video(49);
		assertTrue(db.isRent(c, v1)==false);
		assertTrue(db.isRent(c, v2)==true);
	}

	@Test
	public void testSontdansCategorie() throws SQLException {
		List<Video>videos = new ArrayList<Video>();
		CategorieVideo cv = new CategorieVideo(1);
		videos.add(new Video(1));
		videos.add(new Video(68));
		videos.add(new Video(3));
		assertTrue(db.sontdansCategorie(videos, cv).size()==2);
		assertTrue(db.sontdansCategorie(videos, cv).get(0).getId()==1);
		assertFalse(db.sontdansCategorie(videos, cv).get(1).getId()==68);
		assertTrue(db.sontdansCategorie(videos, cv).get(1).getId()==3);
	}

}
