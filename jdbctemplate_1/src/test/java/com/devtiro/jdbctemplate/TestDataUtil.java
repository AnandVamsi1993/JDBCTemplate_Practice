package com.devtiro.jdbctemplate;

import com.devtiro.jdbctemplate.domain.Author;
import com.devtiro.jdbctemplate.domain.Book;

public final class TestDataUtil {
	
	private TestDataUtil() {};

	public static Author createTestAuthor() {
		return Author.builder()
				.id(1L)
				.name("Abigail Rose")
				.age(80)
				.build();
	}
	
	public static Author createTestAuthorA() {
		return Author.builder()
				.id(2L)
				.name("Abigail Rose1")
				.age(80)
				.build();
	}
	
	public static Author createTestAuthorB() {
		return Author.builder()
				.id(3L)
				.name("Abigail Rose2")
				.age(80)
				.build();
	}
	
	public static Author createTestAuthorC() {
		return Author.builder()
				.id(4L)
				.name("Abigail Rose3")
				.age(80)
				.build();
	}
	
	public static Book createTestBook() {
		return Book.builder()
				.isbn("9876-187659")
				.title("The shadow in the attic")
				.author_id(1L)
				.build();
	}
	
	public static Book createTestBookA() {
		return Book.builder()
				.isbn("9876-1876591")
				.title("The shadow in the attic")
				.author_id(1L)
				.build();
	}
	
	public static Book createTestBookB() {
		return Book.builder()
				.isbn("9876-1876592")
				.title("The shadow in the attic")
				.author_id(1L)
				.build();
	}
	
	public static Book createTestBookC() {
		return Book.builder()
				.isbn("9876-1876593")
				.title("The shadow in the attic")
				.author_id(1L)
				.build();
	}

}
