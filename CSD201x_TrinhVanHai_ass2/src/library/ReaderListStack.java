package library;

import java.util.Scanner;

public class ReaderListStack {
	Scanner inScanner = new Scanner(System.in);
	private int capacity = 2;
	private Reader[] listReader = new Reader[capacity];
	private int top = -1;
	

	

	public Reader[] getListReader() {
		return listReader;
	}
	

	public int getTop() {
		return top;
	}


	public Reader inputReader(){
		Reader reader = new Reader();
		boolean err=false;
		do{
			err = false;
			System.out.println("Code Reader:");
			reader.setRcode(inScanner.nextLine());
			if(!isEmpty()){
				for(int i=0;i<capacity&&listReader[i]!=null;i++){
					if(listReader[i].getRcode().equals(reader.getRcode())){
						err = true;
						System.out.println("Rcode is already exits!");
					}
				}
			}
		}while(reader.getRcode().isEmpty()||err);
		
		do{
			System.out.println("Name Reader:");
			reader.setName(inScanner.nextLine());
		}while(reader.getName().isEmpty());
		
		do{
			try{
				err = false;
				System.out.println("Year Reader(1900<=year<=2010):");
				reader.setByear(Integer.parseInt(inScanner.nextLine()));
			}catch(Exception e){
				err = true;
				System.out.println("Year must be a Int!");
			}
			
		}while(reader.getByear()>2010||reader.getByear()<1900||err);
		
		
		return reader;
		
	}
	 
	 public boolean isFull() {
	        if (capacity == top+1){
	        	return true;
	        } else{
	        	return false;
	        }
	 }
	 public boolean isEmpty() {
	        if (top == -1){
	        	return true;
	        }else{
	        	return false;
	        }
	    }
	 public void push(Reader x){
		 if (isFull()){
	            expandArray();    
	        }
		 listReader[++top] = x;
		 
	    }
	 private void expandArray() {
		 int currentSize = top +1;
		 Reader[] new_listReader = new Reader[currentSize * 2];
	        for(int i=0;i<currentSize;i++){
	        	new_listReader[i] = listReader[i];
	        }
	        listReader = new_listReader;               
	        capacity = new_listReader.length;
	}
	 
	 public Reader pop() {
	        if (isEmpty()) {
	            System.out.println("Reader empty");
	            return null;
	        } else {
	            reduceSize();                 
	            return listReader[top--];
	        }
	    }
	 
	 private void reduceSize() {
		 int currentSize = top+1;
	        if (currentSize < capacity / 2) {
	            Reader[] new_listReader = new Reader[capacity / 2];
	            System.arraycopy(listReader, 0, new_listReader, 0, new_listReader.length);
	            listReader = new_listReader;
	            capacity = new_listReader.length;
	        }
	}

	 public Reader peek(){
		 if (isEmpty()) {
	            System.out.println("Reader is empty");
	            return null;
	        } else {
	            return listReader[top];
	        }
	 }
	 
	public Reader searchByCode(String rcode){
			for(int i=top;i>=0;i--){
				if(listReader[i].getRcode().equals(rcode)){
					return listReader[i];
				}
			}
			return null;
	}
	
	public void displaySearchReader(){
		if(isEmpty()){
			System.out.println("List Reader is Empty");
		}else{
			System.out.println("Do you want to find a Reader by code:");
			String rcode =inScanner.nextLine();
			Reader r = searchByCode(rcode);
			if(r!=null){
				System.out.println(r.outReader());
			}else{
				System.out.println("Not found Reader");
			}
			
		}
			
	}
	
	public void deleteByCodeReader(){
		if(this.isEmpty()){
			System.out.println("Reader is Empty!");
			return;
		}
		System.out.println("Do you want to delete a Reader by code:");
		String rcode =inScanner.nextLine();
		
		ReaderListStack temp = new ReaderListStack();
		Reader x = null, y;
		
		do{
			if(!this.isEmpty()){
				x=this.pop();
				temp.push(x);
			}else{
				System.out.println("Reader not exits!");
				while(!temp.isEmpty()){
					y=temp.pop();
					this.push(y);
				}
				return;
			}
		}while(!x.getRcode().equals(rcode));
		
		y=temp.pop();
		while(!temp.isEmpty()){
			y=temp.pop();
			this.push(y);
		}
		System.out.println("Ok!delete success");
		  
	}

	public String displayReader() {
		String rels="{ \n";
		Reader current;
		 for (int i = top; i >=0; i--) {
			 	current = listReader[i];
			 	rels =rels + current.outReader() +"\n";
	        }
		
		rels = rels+ "}";
		return rels;
	}
	 
}
