package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelservlet.Client;
//Created by Corentin Bouchaudon
class ClientTest {
	Client c;
	@BeforeEach
	void setUp() throws Exception {
		c = new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr");
	}

	@Test
	void testClientStringString() {
		assertTrue(new Client("lol","XD").getPseudo().equals("lol") && new Client("lol","XD").getMdp().equals("XD"));
	}

	@Test
	void testClientInt() {
		assertTrue(new Client(1).getId()==1);
	}

	@Test
	void testClientIntStringStringStringStringString() {
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getId()==1);
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getPrenon().equals("Brian"));
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getNom().equals("Lenormand"));
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getPseudo().equals("Link91"));
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getMdp().equals("kikou91"));
		assertTrue(new Client(1,"Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getEmail().equals("brian.lenormand@u-psud.fr"));
	}

	@Test
	void testClientStringStringStringStringString() {
		assertTrue(new Client("Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getPrenon().equals("Brian"));
		assertTrue(new Client("Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getNom().equals("Lenormand"));
		assertTrue(new Client("Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getPseudo().equals("Link91"));
		assertTrue(new Client("Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getMdp().equals("kikou91"));
		assertTrue(new Client("Lenormand","Brian","Link91","kikou91","brian.lenormand@u-psud.fr").getEmail().equals("brian.lenormand@u-psud.fr"));
	
	}

	@Test
	void testClientString() {
		assertTrue(new Client("coucou").getPseudo().equals("coucou"));
	}

	@Test
	void testGetId() {
		assertTrue(c.getId()==1);
	}

	@Test
	void testSetId() {
		c.setId(2);
		assertTrue(c.getId()==2);
	}

	@Test
	void testGetNom() {
		assertTrue(c.getNom().equals("Lenormand"));
	}

	@Test
	void testSetNom() {
		c.setNom("Paul");
		assertTrue(c.getNom().equals("Paul"));
	}

	@Test
	void testGetPrenon() {
		assertTrue(c.getPrenon().equals("Brian"));
	}

	@Test
	void testSetPrenon() {
		c.setPrenon("Louis");
		assertTrue(c.getPrenon().equals("Louis"));
		
	}

	@Test
	void testGetPseudo() {
		assertTrue(c.getPseudo().equals("Link91"));
	}

	@Test
	void testSetPseudo() {
		c.setPseudo("Lapin");
		assertTrue(c.getPseudo().equals("Lapin"));
	}

	@Test
	void testGetMdp() {
		assertTrue(c.getMdp().equals("kikou91"));
	}

	@Test
	void testSetMdp() {
		c.setMdp("123456");
		assertTrue(c.getMdp().equals("123456"));
	}

	@Test
	void testGetEmail() {
		assertTrue(c.getEmail().equals("brian.lenormand@u-psud.fr"));
	}

	@Test
	void testSetEmail() {
		c.setEmail("a.b@gmail.com");
		assertTrue(c.getEmail().equals("a.b@gmail.com"));
	}

}
