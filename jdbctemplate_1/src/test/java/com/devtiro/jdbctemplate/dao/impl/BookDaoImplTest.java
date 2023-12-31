package com.devtiro.jdbctemplate.dao.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.mockito.ArgumentMatchers;
import com.devtiro.jdbctemplate.TestDataUtil;

import com.devtiro.jdbctemplate.dao.impl.BookDaoImpl;
import com.devtiro.jdbctemplate.domain.Book;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private BookDaoImpl underTest;
	
	
	@Test
	public void testThatCreateBookGeneratesCorrectSql() {
		
		Book book = TestDataUtil.createTestBook();
				
				
		underTest.create(book);
		
		verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
				eq("9876-187659"),eq("The shadow in the attic"),eq(1L));
	}

	@Test
	public void testThatFindOneBookGeneratesCorrectSql() {
		underTest.find("9876-187659");
		verify(jdbcTemplate).query(
				eq("SELECT isbn,title,author_id from books WHERE isbn = ? LIMIT 1"),
				ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
				eq("9876-187659"));
	}
	
	@Test
	public void testThatFindGeneratesCorrectSql() {
		underTest.findAll();
		verify(jdbcTemplate).query(eq("SELECT isbn,title,author_id from books"),
				ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
	}
	
	@Test
	public void testThatUpdateGeneratesCorrectSql() {
		
		Book book = TestDataUtil.createTestBookA();
		underTest.update(book.getIsbn(),book);
		
		verify(jdbcTemplate).update("UPDATE books SET isbn = ?, title = ?, author_id=? where isbn = ?",
				book.getIsbn(),book.getTitle(),book.getAuthor_id(),book.getIsbn());
		
	}
	
	@Test
	public void testThatDeleteGeneratesCorrectSql() {
		Book book = TestDataUtil.createTestBook();
		underTest.delete(book.getIsbn());
		
		verify(jdbcTemplate).update("DELETE FROM books where isbn = ?", book.getIsbn());
	}
	

}
