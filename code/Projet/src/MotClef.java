
public class MotClef {
	private int id;
	private String motClef;
	
	
	
	public MotClef() {		
	}
	public MotClef(int id,String motclef) {
		this.id=id;
		this.motClef=motclef;
	}
	public MotClef(int id) {
		this.id=id;
	}
	public MotClef(String motclef) {
		this.motClef=motclef;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMotClef() {
		return motClef;
	}
	public void setMotClef(String motClef) {
		this.motClef = motClef;
	}
	
}