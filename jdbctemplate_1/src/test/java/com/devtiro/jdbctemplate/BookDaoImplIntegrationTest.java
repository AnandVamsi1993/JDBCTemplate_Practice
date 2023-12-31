package com.devtiro.jdbctemplate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devtiro.jdbctemplate.dao.AuthorDao;
import com.devtiro.jdbctemplate.dao.impl.BookDaoImpl;
import com.devtiro.jdbctemplate.domain.Author;
import com.devtiro.jdbctemplate.domain.Book;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTest {
	
	private AuthorDao authorDao;
	private BookDaoImpl underTest;
	
	@Autowired
	public BookDaoImplIntegrationTest(BookDaoImpl bookDaoimpl, AuthorDao authorDao ) {
		this.underTest = bookDaoimpl;
		this.authorDao = authorDao;
	}
	
	@Test
	public void testthatBookCanBeCreatedAndRecaled() {
		
		Author author = TestDataUtil.createTestAuthor();
		authorDao.create(author);
		Book book = TestDataUtil.createTestBook();
		underTest.create(book);
		book.setAuthor_id(author.getId());
		Optional<Book> result = underTest.find(book.getIsbn());
		assertThat(result).isPresent();
		assertThat(result.get()).isEqualTo(book);
		
	}
	
	@Test
	public void testThatMultipleBooksCanBeCreatedAndRecalled() {
		
		Author author = TestDataUtil.createTestAuthor();
		authorDao.create(author);
		
		Book bookA = TestDataUtil.createTestBookA();
		bookA.setAuthor_id(author.getId());
		underTest.create(bookA);
		
		Book bookB = TestDataUtil.createTestBookB();
		bookB.setAuthor_id(author.getId());
		underTest.create(bookB);
		
		Book bookC = TestDataUtil.createTestBookC();
		bookC.setAuthor_id(author.getId());
		underTest.create(bookC);
		
		List<Book> result = underTest.findAll();
		assertThat(result)
				.hasSize(3)
				.containsExactly(bookA,bookB,bookC);
		
	}
	
	@Test
	public void testThatBookCanBeUpdated() {
		Author author = TestDataUtil.createTestAuthor();
		authorDao.create(author);
		
		Book book = TestDataUtil.createTestBook();
		book.setAuthor_id(author.getId());
		underTest.create(book);
		
		book.setTitle("UPDATED");
		underTest.update(book.getIsbn(), book);
		
		 Optional<Book> result= underTest.find(book.getIsbn());
		 assertThat(result.isPresent());
		 assertThat(result.get()).isEqualTo(book);
		
	}
	
	@Test
	public void testThatBookCanBeDeleted() {
		Author author = TestDataUtil.createTestAuthor();
		authorDao.create(author);
		
		Book book = TestDataUtil.createTestBook();
		book.setAuthor_id(author.getId());
		underTest.create(book);
		
		underTest.delete(book.getIsbn());
		Optional<Book> result= underTest.find(book.getIsbn());
		assertThat(result.isEmpty());
	}
	

}
