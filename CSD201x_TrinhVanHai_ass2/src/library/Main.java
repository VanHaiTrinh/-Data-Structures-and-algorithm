package library;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookList bookList= new BookList();
		ReaderListStack readerList = new ReaderListStack();
		LendingList lendingList = new LendingList();
		do{
				try{
						do { 
								 System.out.println("-------------MENU(Please select the function key)---------------");
							        System.out.println("key 1: Input & add new Book to the end.");
							        System.out.println("key 2: Display data Book.");
							        System.out.println("key 3: Search Book by bcode.");
							        System.out.println("key 4: Input & add new Book to beginning.");
							        System.out.println("key 5: Add new Book after position  k.");
							        System.out.println("key 6: Delete Book at position k.");
							        System.out.println("key 7: Add new Reader.");
							        System.out.println("key 8: Display data Reader.");
							        System.out.println("key 9: Search Reader by rcode.");
							        System.out.println("key 10: Delete Reader by rcode.");
							        System.out.println("key 11: Add Lengding.");
							        System.out.println("key 12: Display data Lengding.");
							        
							        System.out.println("key 0: Exit.");
							        System.out.println("--------------------------------------------------------");
							        System.out.println("--------------------------------------------------------");
							        System.out.print("Please: ");
								   int c = Integer.parseInt(sc.nextLine());
								   switch (c) {
								case 1:
									bookList.addBookAtEnd();
									break;
								case 2:
									System.out.println(bookList.displayBook());
									break;
								case 3:
									bookList.displayBookSearch();
									break;
								case 4:
									bookList.addBookAtHead();
									break;
								case 5:
									bookList.addBookAtAfterK();
									break;
								case 6:
									bookList.deleteBookAtK();
									break;
								case 7:
									readerList.push(readerList.inputReader());
									break;
								case 8:
									System.out.println(readerList.displayReader());
									break;
								case 9:
									readerList.displaySearchReader();
									break;
								case 10:
									readerList.deleteByCodeReader();
									break;
								case 11:
									lendingList.enqueue(lendingList.inputLengding(readerList, bookList));
									break;
								case 12:
									System.out.println(lendingList.diplayLengding());
									break;
								
								case 0:
									break;
								default:
									System.out.println("You must be enter a number from 0 to 12");
									break;
								}
						}while(true);
				}catch(Exception e){
					System.out.println("You must be enter a number from 0 to 12");
				}
		}while(true);		
	}

}
