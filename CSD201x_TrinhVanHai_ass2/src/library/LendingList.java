package library;

import java.util.Scanner;

public class LendingList {
	Scanner inScanner = new Scanner(System.in);
	private int capacity = 2;
	private Lending[] listLengding = new Lending[capacity];
	private int head = -1 ,
			    tail = -1 ,
	            count = 0;
	
	public boolean isEmpty(){
        return count==0;
    }
	
	public boolean isFull(){
        return count==capacity;
    }
	public Lending peek()
    {
        if(isEmpty()){
            System.out.println("Peek: Lending is empty");
            return null;
        }else{
        	return listLengding[head];
        }
    }
	
	public Lending inputLengding(ReaderListStack rl,BookList bl){
		Lending lending = new Lending();
		
		boolean err=false;
		do{
			if(bl.getHeadBook()==null){
				System.out.println("Book is Empty");
				break;
			}else{
				err= false;
				System.out.println("BCode Lengding:");
				lending.setBcode(inScanner.nextLine());
				BookNode current = bl.getHeadBook();
				while(current!=null){
					if(current.getB().getBcode().equals(lending.getBcode())){
						err = true;
						break;
					}
					current = current.getNextNode();
				}
				if(!err){
					System.out.println("Code not exits in List Book");
				}
			}
		}while(lending.getBcode().isEmpty()||!err);
		
		do{
			if(rl.isEmpty()){
				System.out.println("Reader is Empty");
				break;
			}else{
				err= false;
				System.out.println("RCode Lengding:");
				lending.setRcode(inScanner.nextLine());
				
				for(int i = 0;i<=rl.getTop();i++){
					if(rl.getListReader()[i].getRcode().equals(lending.getRcode())){
						err = true;
						break;
					}
				}
				if(!err){
					System.out.println("this code not exits in List Reader");
				}
			}
		}while(lending.getRcode().isEmpty()||!err);
		
		if(lending.getBcode() == null ){
			return null;
		}else if(lending.getRcode() == null){
			return null;
		}else{
			int st = -1;
			do{
				try{
					err = false;
					System.out.println("State:");
					System.out.println("State must be 0 or 1 or 2");
					st = Integer.parseInt(inScanner.nextLine());
					
					lending.setState(st);
					
				}catch(Exception e){
					err = true;
					System.out.println("State must be a Int");
				}
				
			}while(err||st>2||st<0);
		
		}
		
		return lending;
	}
	
	public void enqueue(Lending item){
		if(item==null){
			return;
		}
        if(isFull()){
            resize();
        }
        if(isEmpty()){
        	head = head +1;
        	tail = tail +1;
        	listLengding[tail]=item;
        	count++;
        }else{
        	tail =(tail+1) % capacity;   
            listLengding[tail]=item;
            count++;
        }
    }
	
	public void resize(){
        Lending[] tmp =  new Lending[capacity*2];

        int k = head;
        for (int i = 0; i <= count; i++)
        {
            tmp[i] = listLengding[k];
            k = (k + 1) % count;
        }

        listLengding = tmp;
        head = 0;
        tail = count-1;
        capacity=capacity*2;
    }
	
	 public Lending dequeue()
	    {
	        if(isEmpty()){
	        	System.out.println("Peek: Lending is empty");
	        	return null;
	        }else{
	            count--;
	            head = head +1;
	            return listLengding[head-1];
	        }
	    }
	 
	 public String diplayLengding(){
		 
		 String rels="{ \n";
		    int i=head;
			 for(int j = 0;j<count;j++) {
				 	Lending old = listLengding[i];
				 	rels =rels + old.outLending() +"\n";
				 	i= (i+1)%count;
		        }
			rels = rels+ "}";
			return rels;
	 }

}
