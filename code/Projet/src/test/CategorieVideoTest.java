package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelservlet.CategorieVideo;

public class CategorieVideoTest {
	CategorieVideo cv;
	@Before
	public void setUp() throws Exception {
		cv = new CategorieVideo(1,"Film");
	}

	@Test
	public void testCategorieVideoIntString() {
		assertTrue(new CategorieVideo(1,"Film").getId()==1 && new CategorieVideo(1,"Film").getNomCategorieVideo().equals("Film"));
	}

	@Test
	public void testCategorieVideoInt() {
		assertTrue(new CategorieVideo(1).getId()==1);
	}

	@Test
	public void testGetId() {
		assertTrue(cv.getId()==1);
	}

	@Test
	public void testSetId() {
		cv.setId(2);
		assertTrue(cv.getId()==2);
	}

	@Test
	public void testGetNomCategorieVideo() {
		assertTrue(cv.getNomCategorieVideo().equals("Film"));
	}

	@Test
	public void testSetNomCategorieVideo() {
		cv.setNomCategorieVideo("Documentaire");
		assertTrue(cv.getNomCategorieVideo().equals("Documentaire"));
	}

}
