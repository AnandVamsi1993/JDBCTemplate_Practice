package com.devtiro.jdbctemplate.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import org.springframework.jdbc.core.JdbcTemplate;

import com.devtiro.jdbctemplate.dao.BookDao;
import com.devtiro.jdbctemplate.domain.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {

	private final JdbcTemplate jdbcTemplate;
	
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Book book) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
				book.getIsbn(), book.getTitle(), book.getAuthor_id());
		
	}

	@Override
	public Optional<Book> find(String isbn) {
		// TODO Auto-generated method stub
		List<Book> result = jdbcTemplate.query("SELECT isbn,title,author_id from books WHERE isbn = ? LIMIT 1",
				new BookRowMapper(),
				isbn);
		return result.stream().findFirst();
	}

	public static class BookRowMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return Book.builder()
					.isbn(rs.getString("isbn"))
					.title(rs.getString("title"))
					.author_id(rs.getLong("author_id"))
					.build();
		}
		
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT isbn,title,author_id from books",new BookRowMapper());
	}

	@Override
	public void update(String isbn, Book book) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("UPDATE books SET isbn = ?, title = ?, author_id=? where isbn = ?",
				book.getIsbn(),book.getTitle(),book.getAuthor_id(),isbn);
	}

	@Override
	public void delete(String isbn) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("DELETE FROM books where isbn = ?", isbn);
	}
	
	
}
