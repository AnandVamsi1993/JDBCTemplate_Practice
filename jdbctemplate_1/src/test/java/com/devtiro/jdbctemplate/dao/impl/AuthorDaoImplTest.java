package com.devtiro.jdbctemplate.dao.impl;

import static org.mockito.Mockito.verify;

import javax.swing.tree.RowMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.devtiro.jdbctemplate.TestDataUtil;
import com.devtiro.jdbctemplate.dao.impl.AuthorDaoImpl;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.eq;
import com.devtiro.jdbctemplate.domain.Author;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private AuthorDaoImpl underTest;
	
	@Test
	public void testThatCreateAuthorGeneratesCorrctSql() {
		Author author = TestDataUtil.createTestAuthor();
		underTest.create(author);
		
		verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Abigail Rose"), eq(80));
	}

	@Test
	public void testThatFindOneGeneratesTheCorrectSql() {
		underTest.findOne(1L);
		verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
	}
	
	@Test
	public void testThatFindManyGeneratesCorrectSql() {
		underTest.find();
		verify(jdbcTemplate).query(eq("SELECT id,name,age FROM authors"), 
				ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
	}
	
	@Test
	public void testThatUpdateGenerateTheCorrectSql() {
		Author author = TestDataUtil.createTestAuthor();
		underTest.update(author.getId(),author);
		verify(jdbcTemplate).update("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
				1L,"Abigail Rose",80,1L);
	}
	
	@Test
	public void testThatDeleteGeneratesTheCorrectSql() {
		Author author = TestDataUtil.createTestAuthor();
		
		underTest.delete(author.getId());
		verify(jdbcTemplate).update("DELETE authors where id = ?", author.getId());
	}

}
