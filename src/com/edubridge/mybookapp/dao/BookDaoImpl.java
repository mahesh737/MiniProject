package com.edubridge.mybookapp.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.edubridge.mybookapp.model.Book;

	import com.edubridge.mybookapp.utils.DBUtils;

	public class BookDaoImpl implements BookDao {

		static Connection con = DBUtils.getConection();

		@Override
		public int addBook(Book c) {
			String INSERT_QUERY = "insert into book(id,title,author,language,pagecount,Price) values(?,?,?,?,?,?) ";
			int status = 0;
			try {
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
				ps.setInt(1, c.getId());
				ps.setString(2, c.getTitle());
				ps.setString(3, c.getAuthor());
				ps.setString(4, c.getLanguage());
				ps.setInt(5, c.getPagecount());
				ps.setFloat(6, c.getPrice());
				

				status = ps.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return status;
		}

		public List<Book> findBooks() {

			String SELECT_QUERY = "select* from book";

			List<Book> contactList = new ArrayList<>();

			try {
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Book c = new Book();
					c.setId(rs.getInt("id"));
					c.setTitle(rs.getString("Title"));
					c.setAuthor(rs.getString("Author"));
					c.setLanguage(rs.getString("Language"));
					c.setPagecount(rs.getInt("Pagecount"));
					c.setPrice(rs.getFloat("Price"));
					contactList.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return contactList;

		}

		@Override
		public int updateBook(Book c) {
			String UPDATE_QUERY = "update book set Title=?,Author=?,Language=?,Pagecount=?,Price=? where id=?";
			int status = 0;
			try {
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
				ps.setString(1, c.getTitle());
				ps.setString(2, c.getAuthor());
				ps.setString(3, c.getLanguage());
				ps.setInt(4, c.getPagecount());
				ps.setFloat(5, c.getPrice());
				ps.setInt(6, c.getId());

				status = ps.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return status;

		}

		@Override
		public int deleteBookById(int Id) {
			String DELETE_QUERY = "delete from  where Id=?";
			int status = 0;

			try {
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
				ps.setInt(1, Id);
				status = ps.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return status;
		}

		@Override
		public void deleteAllBooks() {
			String DELETE_QUERY = "delete from book";
			try {
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		

		@Override
		public Book findBookById(int Id) {
			Book c = null;

			String SELECT_QUERY = "Select * from book where id=?";
			try {
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
				ps.setInt(1, Id);

				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					c = new Book();
					c.setId(rs.getInt("id"));
					c.setTitle(rs.getString("Title"));
					c.setAuthor(rs.getString("Author"));
					c.setLanguage(rs.getString("Language"));
					c.setPagecount(rs.getInt("Pagecount"));
					c.setPrice(rs.getFloat("Price"));

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return c;
		}

	}
	


