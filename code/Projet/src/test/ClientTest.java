package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelservlet.Client;

public class ClientTest {
	Client c;

	@Before
	public void setUp() throws Exception {
		c = new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr");
	}

	@Test
	public void testClientStringString() {
		assertTrue(new Client("lol", "XD").getPseudo().equals("lol") && new Client("lol", "XD").getMdp().equals("XD"));
	}

	@Test
	public void testClientInt() {
		assertTrue(new Client(1).getId() == 1);
	}

	@Test
	public void testClientIntStringStringStringStringString() {
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getId() == 1);
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getPrenon()
				.equals("Brian"));
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getNom()
				.equals("Lenormand"));
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getPseudo()
				.equals("Link91"));
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getMdp()
				.equals("kikou91"));
		assertTrue(new Client(1, "Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getEmail()
				.equals("brian.lenormand@u-psud.fr"));
	}

	@Test
	public void testClientStringStringStringStringString() {
		assertTrue(new Client("Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getPrenon()
				.equals("Brian"));
		assertTrue(new Client("Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getNom()
				.equals("Lenormand"));
		assertTrue(new Client("Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getPseudo()
				.equals("Link91"));
		assertTrue(new Client("Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getMdp()
				.equals("kikou91"));
		assertTrue(new Client("Lenormand", "Brian", "Link91", "kikou91", "brian.lenormand@u-psud.fr").getEmail()
				.equals("brian.lenormand@u-psud.fr"));

	}

	@Test
	public void testClientString() {
		assertTrue(new Client("coucou").getPseudo().equals("coucou"));
	}

	@Test
	public void testGetId() {
		assertTrue(c.getId() == 1);
	}

	@Test
	public void testSetId() {
		c.setId(2);
		assertTrue(c.getId() == 2);
	}

	@Test
	public void testGetNom() {
		assertTrue(c.getNom().equals("Lenormand"));
	}

	@Test
	public void testSetNom() {
		c.setNom("Paul");
		assertTrue(c.getNom().equals("Paul"));
	}

	@Test
	public void testGetPrenon() {
		assertTrue(c.getPrenon().equals("Brian"));
	}

	@Test
	public void testSetPrenon() {
		c.setPrenon("Louis");
		assertTrue(c.getPrenon().equals("Louis"));

	}

	@Test
	public void testGetPseudo() {
		assertTrue(c.getPseudo().equals("Link91"));
	}

	@Test
	public void testSetPseudo() {
		c.setPseudo("Lapin");
		assertTrue(c.getPseudo().equals("Lapin"));
	}

	@Test
	public void testGetMdp() {
		assertTrue(c.getMdp().equals("kikou91"));
	}

	@Test
	public void testSetMdp() {
		c.setMdp("123456");
		assertTrue(c.getMdp().equals("123456"));
	}

	@Test
	public void testGetEmail() {
		assertTrue(c.getEmail().equals("brian.lenormand@u-psud.fr"));
	}

	@Test
	public void testSetEmail() {
		c.setEmail("a.b@gmail.com");
		assertTrue(c.getEmail().equals("a.b@gmail.com"));
	}
}
