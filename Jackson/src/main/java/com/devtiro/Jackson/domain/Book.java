package com.devtiro.Jackson.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
	
	private String isbn;
	
	private String title;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "author_id")
	String author;
	String yearPublished;

}

