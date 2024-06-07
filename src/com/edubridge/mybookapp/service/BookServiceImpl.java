
	package com.edubridge.mybookapp.service;

	import java.util.List;

	import com.edubridge.mybookapp.dao.BookDao;
	import com.edubridge.mybookapp.dao.BookDaoImpl;
	import com.edubridge.mybookapp.model.Book;

	public   class BookServiceImpl  implements BookService {
	      BookDao dao = new BookDaoImpl();	
		
		@Override
		public int addBook(Book c) {
			
			return dao.addBook(c);
		}

		@Override
		public List<Book> findBook() {
			// TODO Auto-generated method stub
			return dao.findBooks();
		}

		@Override
		public Book findBookById(int Id) {
			// TODO Auto-generated method stub
			return dao.findBookById(Id);
		}

		@Override
		public int updateBook(Book c){
			// TODO Auto-generated method stub
			return dao.updateBook(c);
		}
		@Override
		public int deleteBookById(int Id) {
			// TODO Auto-generated method stub
			return dao.deleteBookById(Id);
		}

		@Override
		public void deleteAllBooks() {
			
		}

		@Override
		public int deletBookById(int Id) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
