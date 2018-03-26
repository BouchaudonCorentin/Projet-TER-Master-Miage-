package modelservlet;

/** This class allow to create keyword to add to the database
 * 
 * @autho Corentin Bouchaudon
 *
 */
//Created by Corentin Bouchaudon
public class MotClef {
	private int id;
	private String motClef;
	
	
	
	/**
	 * 
	 */
	public MotClef() {		
	}
	/**
	 * @param id
	 * @param motclef
	 */
	public MotClef(int id,String motclef) {
		this.id=id;
		this.motClef=motclef;
	}
	/**
	 * @param id
	 */
	public MotClef(int id) {
		this.id=id;
	}
	/**
	 * @param motclef
	 */
	public MotClef(String motclef) {
		this.motClef=motclef;
	}
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getMotClef() {
		return motClef;
	}
	/**
	 * @param motClef
	 */
	public void setMotClef(String motClef) {
		this.motClef = motClef;
	}
	
}
