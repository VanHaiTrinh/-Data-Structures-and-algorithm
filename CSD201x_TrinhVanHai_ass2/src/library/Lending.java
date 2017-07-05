package library;

public class Lending {
	private String bcode;
	private String rcode;
	private int state;
	
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public String outLending(){
		return "bcode:" + this.bcode + "|" + "rcode:" + this.rcode + "|" + "state:" + this.state;
	}
}
