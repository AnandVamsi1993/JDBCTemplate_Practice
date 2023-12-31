package com.devtiro.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

import com.devtiro.jdbctemplate.domain.Book;

public interface BookDao {

	public void create(Book book);
	Optional<Book> find(String isbn);
	List<Book> findAll();
	void update(String isbn, Book book);
	void delete(String isbn);
}
