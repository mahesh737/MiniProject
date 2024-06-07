
	package com.edubridge.mybookapp.service;

	import java.util.List;

	import com.edubridge.mybookapp.model.Book;


	public interface BookService {
		int addBook( Book c);
		List<Book> findBook();
		Book findBookById(int Id);
		int updateBook(Book c);
		int deleteBookById(int Id);
		void deleteAllBooks();
		int deletBookById(int Id);
		
	}
	


