package com.devtiro.Jackson.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtiro.Jackson.domain.Book;

import lombok.extern.java.Log;

@RestController
@Log
public class BookController {
	
	@GetMapping(path = "/books")
	public Book retrieveBook() {
		return Book.builder()
				.isbn("987-654-321-0")
				.title("The Enigma of Eternity")
				.author("Aria Montgomery")
				.yearPublished("2005")
				.build();
		
	}
	
	@PostMapping(path = "/books")
	public Book createBook(@RequestBody final Book book) {
		log.info("Got Book: "+ book.toString());
		return book;
	}

}
