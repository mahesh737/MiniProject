package com.edubridge.mybookapp.dao;

	import java.util.List;

	import com.edubridge.mybookapp.model.Book;

	public interface BookDao {
			int addBook(Book c);
			List<Book> findBooks();
			Book findBookById(int id);
			int updateBook(Book c);
			int deleteBookById(int id);
			void deleteAllBooks();		
		                                                         
}
