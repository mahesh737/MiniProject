package com.edubridge.mybookapp.main;


	import java.util.List;
	import java.util.Scanner;

	import com.edubridge.mybookapp.model.Book;
	import com.edubridge.mybookapp.service.BookService;
	import com.edubridge.mybookapp.service.BookServiceImpl;


	public class BookMainApp {
		public static void main(String[] args) {
			BookService service = new BookServiceImpl();
			Book c = null;
			Scanner in = new Scanner(System.in);
			int option;
			do {
				System.out.println("welcome to Book App");
				System.out.println("*");
				System.out.println("1. Add book");
				System.out.println("2. view book");
				System.out.println("3. Search book");
				System.out.println("4. Update book");
				System.out.println("5. Delete book");
				System.out.println("6. DeleteAll books");
				System.out.println("0. exit");
				System.out.println("please choose option");
				option = in.nextInt();

				switch (option) {
				case 1:
					System.out.println(" Add NEW BOOK ");
					System.out.println("-----------------");
					System.out.println("please enter id: ");
					int Id = in.nextInt();
					System.out.println("Please enter title name: ");
					String Title = in.next();
					System.out.println("please enter author: ");
					String Author = in.next();
					System.out.println("please enter language: ");
					String Language =in.next();
					System.out.println("please enter pagecount: ");
					int Pagecount = in.nextInt();
					System.out.println("please enter price: ");
					float Price =in.nextFloat();
					c=new Book();
					c.setTitle(Title);
					c.setAuthor(Author);
					c.setLanguage(Language);
					c.setPagecount(Pagecount);
					c.setPrice(Price);
					
					int status =service.addBook(c);
					if(status==1) {
						System.out.println("New book added!");

					}else {
						System.out.println("something is wrong!");

					}

					break;
				case 2:
					System.out.println("view All books");
					List<Book> boo=service.findBook();
					System.out.println("TITLE\tAUTHOR\tLANGUAGE\tPAGECOUNT\tPRICE");
					System.out.println("------\t-------\t-------\t-----\t------");

					for(Book book:boo) {
						System.out.println(book.getTitle()+"\t" +book.getAuthor()+"\t"+book.getLanguage()+"\t"+book.getPagecount()+"\t"+book.getPrice());

					}
					break;
				case 3:
					
					System.out.println("search 	book");
					System.out.println("please enter book id");
					int searchId=in.nextInt();
			        Book searchBook=service.findBookById(searchId);
					if(searchBook !=null) {
						System.out.println("ID: "+searchBook.getId());
						System.out.println("Title: "+searchBook.getTitle());
						System.out.println("Author: "+searchBook.getAuthor());
						System.out.println("Language: "+searchBook.getLanguage());
						System.out.println("Pagecount:"+searchBook.getPagecount());
						System.out.println("Price:"+searchBook.getPrice());
						
					}else {
						System.out.println("No book found!");
					}
					
					break;
					
				case 4:
					//System.out.println("update Contact");
					System.out.println("please enter id:");
					searchId=in.nextInt();				
					searchBook=service.findBookById(searchId);
					
					if(searchId !=0) {
						//displaying existing contact details
						System.out.println("ID: "+searchBook.getId());  
						System.out.println("Title: "+searchBook.getTitle());
						System.out.println("Author: "+searchBook.getAuthor());
						System.out.println("Language: "+searchBook.getLanguage());
						System.out.println("Pagecount:"+searchBook.getPagecount());
						System.out.println("Price:"+searchBook.getPrice());
						
						//reading contact update info
						System.out.println("please enter updated title:");
						Title=in.next();
						System.out.println("please enter update author:");
						Author=in.next();
						System.out.println("please enter update language:");
						Language=in.next();
						System.out.println("please enter update pagecount:");
						Pagecount=in.nextInt();
						System.out.println("please enter update price:");
						Price=in.nextFloat();
						
						Book updateBook=new Book();
						updateBook.setTitle(Title);
	                    updateBook.setAuthor(Author);
	                    updateBook.setAuthor(Language);
	                    updateBook.setId(searchBook.getId());
	                    
	                    int updateStatus =service.updateBook(updateBook);
	                    if(updateStatus ==1) {
	                    	System.out.println("contact updated successfully");
	                    }else {
	                    	System.out.println("something is wrong !");
	                    }
						
					}else {
						System.out.println("contact not found with id");
					}
					break;
				case 5:
					System.out.println("delete book");
					System.out.println("please enter book id");
					searchId = in.nextInt();
					searchBook = service.findBookById(searchId);
					if(searchBook !=null) {
						int deleteStatus = service.deleteBookById(searchId);
						if(deleteStatus==1) {
							System.out.println("book deleted sucessfully");
						}else {
							System.out.println("something went wrong");
						}
						
					}
							break;
				case 6:
					System.out.println(" Are you sure delete All books?[Y/N]");
					String deleteConfirmStatus = in.next();
					if(deleteConfirmStatus.equalsIgnoreCase("Y")){
						service.deleteAllBooks();
						System.out.println("all books deleted ");
					}
					break;
				case 0:
					System.out.println("Bye!!!");
					System.exit(0);
					break;
				default:
					System.out.println("invalid option!");
					break;

				}
			} while (option != 0);
		}

	}



