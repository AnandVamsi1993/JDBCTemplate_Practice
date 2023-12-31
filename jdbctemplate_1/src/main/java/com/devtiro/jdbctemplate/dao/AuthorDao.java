package com.devtiro.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

import com.devtiro.jdbctemplate.domain.Author;

public interface AuthorDao {
	
	public void create(Author author);
	public Optional<Author> findOne(long L);
	public List<Author> find();
	public void update(long id,Author author);
	public void delete(long l);

}
