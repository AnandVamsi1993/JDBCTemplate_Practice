package com.devtiro.jdbctemplate.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import com.devtiro.jdbctemplate.dao.AuthorDao;
import com.devtiro.jdbctemplate.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorDaoImpl implements AuthorDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Author author) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
							author.getId(), author.getName(), author.getAge());
	}

	@Override
	public Optional<Author> findOne(long authorId) {
		// TODO Auto-generated method stub
		 List<Author> results = jdbcTemplate.query(
				 "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1", 
				 new AuthorRowMapper(),
				 authorId);
		 return results.stream().findFirst();
	}
	
	public static class AuthorRowMapper implements RowMapper<Author>{

		@Override
		public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return Author.builder()
					.id(rs.getLong("id"))
					.name(rs.getString("name"))
					.age(rs.getInt("age"))
					.build();
		}
		
	}

	@Override
	public List<Author> find() {
		// TODO Auto-generated method stub
		List<Author> results = jdbcTemplate.query("SELECT id,name,age FROM authors", 
				new AuthorRowMapper());
		return results;
	}

	@Override
	public void update(long id,Author author) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
				author.getId(),author.getName(),author.getAge(),id);
	}

	@Override
	public void delete(long author_id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("DELETE authors where id = ?", author_id);
	}

	

}
