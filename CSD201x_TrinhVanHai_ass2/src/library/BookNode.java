package library;

public class BookNode {
	private Book b;
	private BookNode nextNode;
	

	public BookNode(Book b) {
		this.b = b;
	}
	
	
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	public BookNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(BookNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public String outBook() {
		return "Code: "+this.b.getBcode()+"|"+"Title: "+this.b.getTitle()+"|"+"Quantity: "+this.b.getQuantity()+"|"+"Lended: "
						+this.b.getLended()+"|"+"Price: "+this.b.getPrice()+"|"+"Value: "+ this.b.getPrice()*this.b.getQuantity();
	}
	
	
}
