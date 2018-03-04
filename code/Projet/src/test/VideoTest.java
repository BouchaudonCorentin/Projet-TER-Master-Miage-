package test;
//Created by Corentin Bouchaudon
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelservlet.Video;

public class VideoTest {
	Video v ;
	@Before
	public void setUp() throws Exception {
		v = new Video(1,"a","b",0,"c",10,12,2.99,3.99);
	}

	@Test
	public void testVideoStringStringInt() {
		assertTrue(new Video("a","b",1).getNomVideo().equals("a")&& new Video("a","b",1).getGroupeVideo().equals("b")&& new Video("a","b",1).getNumepisode()==1);
	}

	@Test
	public void testVideoStringStringIntStringIntIntDoubleDouble() {
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getNomVideo().equals("a"));
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getGroupeVideo().equals("b"));
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getNumepisode()==0);
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getResume().equals("c"));
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getNbvue()==10);
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getNbddl()==12);
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getPrixAchat()==2.99);
		assertTrue(new Video("a","b",0,"c",10,12,2.99,3.99).getPrixLocation()==3.99);
	}

	@Test
	public void testGetNbddl() {
		assertTrue(v.getNbddl()==12);
	}

	@Test
	public void testSetNbddl() {
		v.setNbddl(120);
		assertTrue(v.getNbddl()==120);
	}

	@Test
	public void testVideoIntStringStringInt() {
		assertTrue(new Video(1,"a","b",0).getId()==1);
		assertTrue(new Video(1,"a","b",0).getNomVideo().equals("a"));
		assertTrue(new Video(1,"a","b",0).getGroupeVideo().equals("b"));
		assertTrue(new Video(1,"a","b",0).getNumepisode()==0);
	}

	@Test
	public void testGetResume() {
		assertTrue(v.getResume().equals("c"));
	}

	@Test
	public void testSetResume() {
		v.setResume("d");
		assertTrue(v.getResume().equals("d"));		
	}

	@Test
	public void testGetNumepisode() {
		assertTrue(v.getNumepisode()==0);
	}

	@Test
	public void testSetNumepisode() {
		v.setNumepisode(7);
		assertTrue(v.getNumepisode()==7);
	}

	@Test
	public void testVideoIntStringStringIntStringIntIntDoubleDouble() {
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getId()==1);
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getNomVideo().equals("a"));
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getGroupeVideo().equals("b"));
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getNumepisode()==0);
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getResume().equals("c"));
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getNbvue()==10);
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getNbddl()==12);
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getPrixAchat()==2.99);
		assertTrue(new Video(1,"a","b",0,"c",10,12,2.99,3.99).getPrixLocation()==3.99);
	}

	@Test
	public void testVideoString() {
		assertTrue(new Video("a").getNomVideo().equals("a"));
	}

	@Test
	public void testVideoInt() {
		assertTrue(new Video(1).getId()==1);
	}

	@Test
	public void testGetId() {
		assertTrue(v.getId()==1);
	}

	@Test
	public void testSetId() {
		v.setId(2);
		assertTrue(v.getId()==2);
	}

	@Test
	public void testGetNomVideo() {
		assertTrue(v.getNomVideo().equals("a"));
	}

	@Test
	public void testSetNomVideo() {
		v.setNomVideo("b");
		assertTrue(v.getNomVideo().equals("b"));
	}

	@Test
	public void testGetGroupeVideo() {
		assertTrue(v.getGroupeVideo().equals("b"));
	}

	@Test
	public void testSetGroupeVideo() {
		v.setGroupeVideo("m");
		assertTrue(v.getGroupeVideo().equals("m"));
	}

	@Test
	public void testGetNbvue() {
		assertTrue(v.getNbvue()==10);
	}

	@Test
	public void testSetNbvue() {
		v.setNbvue(123);
		assertTrue(v.getNbvue()==123);
	}

	@Test
	public void testGetPrixAchat() {
			assertTrue(v.getPrixAchat()==2.99);
	}

	@Test
	public void testSetPrixAchat() {
		v.setPrixAchat(8.26);
		assertTrue(v.getPrixAchat()==8.26);
	}

	@Test
	public void testGetPrixLocation() {
		assertTrue(v.getPrixLocation()==3.99);
	}

	@Test
	public void testSetPrixLocation() {
		v.setPrixLocation(4.21);
		assertTrue(v.getPrixLocation()==4.21);
	}

}
