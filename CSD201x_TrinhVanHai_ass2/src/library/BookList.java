package library;

import java.util.Scanner;



public class BookList {
	Scanner input= new Scanner(System.in);
	private BookNode headBook;
	
	
	public BookNode getHeadBook() {
		return headBook;
	}

	public void setHeadBook(BookNode headBook) {
		this.headBook = headBook;
	}

	public Book inputBook(){
		Book b=new Book();
		boolean error = false;
		
		do{
			error = false;
			System.out.println("Code book:");
			b.setBcode(input.nextLine());
			if(this.headBook!=null){
				BookNode current = this.headBook;
				while(current!=null){
					if(current.getB().getBcode().equals(b.getBcode())){
						error = true;
						System.out.println("Bcode is already exits!");
						break;
					}
						current = current.getNextNode();
				}
			}
		}while(b.getBcode().isEmpty()||error);
		
		do{
			System.out.println("Title book:");
			b.setTitle(input.nextLine());
		}while(b.getTitle().isEmpty());
		
		do {
			try{
				error= false;
				System.out.println("Quantity book:");
				b.setQuantity(Integer.parseInt(input.nextLine()));
				if(b.getQuantity()< 0){
					System.out.println("Quantity >=0");
				}
			} catch(Exception e){
				error=true;
				System.out.println("Quantity must be a Int");
			}
		} while (b.getQuantity()<0||error);
		
		
		do {
			try{
				error= false;
				System.out.println("Lended book:");
				b.setLended(Integer.parseInt(input.nextLine()));
				if(b.getLended()< 0){
					System.out.println("Lended book >=0");
				}
			} catch(Exception e){
				error=true;
				System.out.println("Lended book must be a Int");
			}
		} while (b.getLended()<0||error);
		
		do {
			try{
				error= false;
				System.out.println("Price book:");
				b.setPrice(Double.parseDouble(input.nextLine()));
				if(b.getPrice()< 0){
					System.out.println("Price book >=0");
				}
			} catch(Exception e){
				error=true;
				System.out.println("Price book must be a double");
			}
		} while (b.getPrice()<0||error);
		
		return b;
	}
		
	public void addBookAtEnd(){
		BookNode newBookNode = new BookNode(inputBook());
		 if(this.headBook == null) {
			 headBook = newBookNode;
	        }else if(this.headBook.getNextNode()==null){
	        	this.headBook.setNextNode(newBookNode);
	        }else{
	        	BookNode current = this.headBook.getNextNode();
	        	  while(current.getNextNode()!= null){
	        		  current = current.getNextNode();
	        	  }
	        	  current.setNextNode(newBookNode);
	        }
	}	
	
	public void addBookAtHead(){
		BookNode newBookNode = new BookNode(inputBook());
		newBookNode.setNextNode(this.headBook);
		this.headBook = newBookNode;
	}
	
	public String displayBook(){
		String result="{ \n";
		BookNode current = this.headBook;
		while(current!=null){
			result =result + current.outBook()+ "\n";
			current = current.getNextNode();
		}
		
		result +="}";
		return result;
	}

	public BookNode search(String xcode){
		boolean found = false;
		BookNode current = this.headBook;
		while(current!=null){
			if(current.getB().getBcode().equals(xcode)){
				found = true;
				break;
			}else{
				current = current.getNextNode();
			}
		}
		if(!found){
			return null;
		}
		return current;
	}
	
	public void displayBookSearch(){
		System.out.println("Do you want to find a book by code:");
		String xcode =input.nextLine();
		if(search(xcode)!=null){
			System.out.println(search(xcode).outBook());
		}else{
			System.out.println("Sorry, Not found book!");
		}
	}
	
	public int length(){
		int length=0;
		BookNode current = this.headBook;
		
		while(current!=null){
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	public void addBookAtAfterK(){
		int k = 0;
		do{
			try{
				System.out.println("Enter position k where you want to add:");
				k = Integer.parseInt(input.nextLine());
				if(k< 0){
					System.out.println("k >=0");
				}
			}catch(Exception e){
				k=-1;
				System.out.println("k must be Int");
			}
		}while(k<0);
		
		BookNode newBookNode = new BookNode(inputBook());
		
		if(this.headBook==null){
			 this.headBook=newBookNode; 
		}else if(k==0){
			newBookNode.setNextNode(headBook.getNextNode());
			this.headBook.setNextNode(newBookNode);
		}else{
			BookNode prev = null;
			BookNode current = this.headBook;
			 
			if(k>=this.length()){
				while (current.getNextNode() !=null) {
			        prev = current;
			        current = current.getNextNode();
			    }
				current.setNextNode(newBookNode);
			}else{
				 int i=-1;
				 while (current.getNextNode() !=null && i <= k) {
				        prev = current;
				        current = current.getNextNode();
				        i++;
				    }
				 
				newBookNode.setNextNode(current);
				prev.setNextNode(newBookNode);
			}
		}
	}
	
	public void deleteBookAtK(){
		if(this.headBook==null){
			System.out.println("List is Empty!");
		}else{
			int k = 0;
			do{
				try{
					System.out.println("Enter position k where you want to delete:");
					k = Integer.parseInt(input.nextLine());
					if(k< 0){
						System.out.println("k >=0");
					}
				}catch(Exception e){
					k=-1;
					System.out.println("k must be Int");
				}
			}while(k<0);
			
			if(k==0){
				this.headBook=this.headBook.getNextNode();
			}
			else if(k>=this.length()){
				System.out.println("Position k not exits!");
			}else{
				BookNode prev = null;
				BookNode current = this.headBook;
				int i=0;
				 while (current.getNextNode()!=null && i <k) {
				        prev = current;
				        current = current.getNextNode();
				        i++;
				}
				 prev.setNextNode(current.getNextNode());
			}
		}
	}
}

