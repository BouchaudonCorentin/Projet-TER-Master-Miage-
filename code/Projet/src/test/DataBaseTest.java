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
		assertTrue(db.suggestions(new Video(1,"Star Wars La Menace Fantome","",1,"Avant de devenir un c�l�bre chevalier Jedi, et bien avant de se r�v�ler l �me la plus noire de la galaxie, Anakin Skywalker est un jeune esclave sur la plan�te Tatooine. La Force est d�j� puissante en lui et il est un remarquable pilote de Podracer. Le ma�tre Jedi Qui-Gon Jinn le d�couvre et entrevoit alors son immense potentiel.Pendant ce temps, l arm�e de dro�des de l insatiable F�d�ration du Commerce a envahi Naboo, une plan�te pacifique, dans le cadre d n plan secret des Sith visant � accro�tre leur pouvoir. Pour d�fendre la reine de Naboo, Amidala, les chevaliers Jedi vont devoir affronter le redoutable Seigneur Sith, Dark Maul.",666,100, 3.99,5.99),mc).get(0).getId()==2);
		mc= new ArrayList();
		mc.add(new MotClef(3));
		mc.add(new MotClef(9));
		mc.add(new MotClef(11));
		assertTrue(db.suggestions(new Video(74,"Black Mirror","4",1,"Chaque �pisode de cette anthologie montre la d�pendance des hommes vis-�-vis de tout ce qui a un �cran...",250,100, 2.99,3.99),mc).get(0).getId()==75);
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
		assertTrue(db.incrementevue(new Video(20,"Star Trek Discovery","1",5,"Apr�s un si�cle de silence, les klingons refont surface. D�termin�s � r�unifier leur empire, ils d�clarent la guerre � la F�d�ration des plan�tes unies. Officier en disgr�ce de la Starfleet, Michael Burnham se retrouve au centre du conflit.",200,100, 1.99,3.99)).getNbvue()==201);
	}

	@Test
	public void testIncrementeddl() throws SQLException {
		assertTrue(db.incrementeddl(new Video(20,"Star Trek Discovery","1",5,"Apr�s un si�cle de silence, les klingons refont surface. D�termin�s � r�unifier leur empire, ils d�clarent la guerre � la F�d�ration des plan�tes unies. Officier en disgr�ce de la Starfleet, Michael Burnham se retrouve au centre du conflit.",200,100, 1.99,3.99)).getNbddl()==101);
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
		Video video = new Video("L homme sur Mars","",0,"A premi�re vue, Loretta est une femme polyn�sienne comme beaucoup d autres. Sa maison, les courses au magasin, le jardin, les chiens accaparent une partie de son temps. Mais une toute petite partie seulement, car vous la trouverez plus souvent une gaffe, des hame�ons ou un couteau � la main, v�tue d un gros cir� et de bottes en caoutchouc plut�t que d un pareo et d escarpins, pataugeant dans l eau sal�, le sang de poissons du large ou la glace pil�e. Partons � la rencontre de Loretta, la seule femme polyn�sienne embarqu�e sur un palangrier et qui fait mentir la sacro-sainte r�gle de tout marin p�cheur : �Pas de femme � bord !�",100,100, 3.99,8.99);
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
	}*/

	@Test
	public void testAcheter() throws SQLException {
		assertTrue(db.louer(new Client(1), new Video(89))==true);
	}

	/*@Test
	public void testRechercheVideoCate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAfficheVideosansDoublon() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrouveridvianomnomgroupetnbepisode() {
		fail("Not yet implemented");
	}

	@Test
	public void testListMembrepremium() {
		fail("Not yet implemented");
	}

	@Test
	public void testLocationsCouranteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testVieilleLocationsUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchatsUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testMotClefvideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchVideoByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testIdByPseudo() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsBuy() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsRent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSontdansCategorie() {
		fail("Not yet implemented");
	}*/

}
