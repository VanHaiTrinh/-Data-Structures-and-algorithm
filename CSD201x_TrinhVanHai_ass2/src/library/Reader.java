package library;

public class Reader {
	private String rcode;
	private String name;
	private int byear;
	
	public Reader() {
		
	}
	
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getByear() {
		return byear;
	}
	public void setByear(int byear) {
		this.byear = byear;
	}
	
	public String outReader(){
		return "Rcode:" + this.rcode + "|" + "Name:" + this.name + "|" + "Year:" + this.byear;
	}
} 
