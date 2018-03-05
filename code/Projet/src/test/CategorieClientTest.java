package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelservlet.CategorieClient;
/**
 * @author Corentin Bouchaudon
 *
 */
public class CategorieClientTest {
	CategorieClient cc;
	@Before
	public void setUp() throws Exception {
		cc = new CategorieClient(1,"Inscrit");
	}

	@Test
	public void testCategorieClientString() {
		assertTrue(new CategorieClient("Inscrit").getCategorie().equals("Inscrit"));
	}

	@Test
	public void testCategorieClientIntString() {
		assertTrue(new CategorieClient(1,"Inscrit").getCategorie().equals("Inscrit") && new CategorieClient(1,"inscrit").getIdcategorie()==1);
	}
	@Test
	public void testGetIdcategorie() {
		assertTrue(cc.getIdcategorie()==1);
	}

	@Test
	public void testCategorieClientInt() {
		assertTrue(new CategorieClient(1).getIdcategorie()==1);
	}

	@Test
	public void testSetIdcategorie() {
		cc.setIdcategorie(2);
		assertTrue(cc.getIdcategorie()==2);
	}

	@Test
	public void testGetCategorie() {
		assertTrue(cc.getIdcategorie()==1);
	}

	@Test
	public void testSetCategorie() {
		cc.setCategorie("Premium");
		assertTrue(cc.getCategorie().equals("Premium"));
	}

}
