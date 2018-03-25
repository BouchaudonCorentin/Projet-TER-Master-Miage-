package test;
/**
 * @author Corentin Bouchaudon
 *
 */
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import modelservlet.MotClef;

public class MotClefTest {
	MotClef mc;
	@Before
	public void setUp() throws Exception {
		mc= new MotClef(1,"Humour");
	}

	@Test
	public void testMotClefIntString() {
		assertTrue(new MotClef(1,"Humour").getId()==1 && new MotClef(1,"Humour").getMotClef().equals("Humour"));
	}

	@Test
	public void testMotClefInt() {
		assertTrue(new MotClef(1).getId()==1);
	}

	@Test
	public void testMotClefString() {
		assertTrue(new MotClef("Humour").getMotClef().equals("Humour"));
	}

	@Test
	public void testGetId() {
		assertTrue(mc.getId()==1);
	}

	@Test
	public void testSetId() {
		mc.setId(2);
		assertTrue(mc.getId()==2);
	}

	@Test
	public void testGetMotClef() {
		assertTrue(mc.getMotClef().equals("Humour"));
	}

	@Test
	public void testSetMotClef() {
		mc.setMotClef("Aventure");
		assertTrue(mc.getMotClef().equals("Aventure"));
	}

}
