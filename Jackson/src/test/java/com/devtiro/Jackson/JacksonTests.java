package com.devtiro.Jackson;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.devtiro.Jackson.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTests {
	
	@Test
	public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Book book = Book.builder()
				.isbn("987-654-321-0")
				.title("The Enigma of Eternity")
				.author("Aria Montgomery")
				.yearPublished("2005")
				.build();
		String result = objectMapper.writeValueAsString(book);
		assertThat(result).isEqualTo( "{\"foo\":\"bar\",\"isbn\":\"987-654-321-0\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
                + " Montgomery\",\"year\":\"2005\"}");
	}
	
	@Test
	public void testThatObjectMapperCanConvertJavaObjectFromJsonObject() throws JsonProcessingException {
		Book book = Book.builder()
				.isbn("987-654-321-0")
				.title("The Enigma of Eternity")
				.author("Aria Montgomery")
				.yearPublished("2005")
				.build();
		String json =  "{\"isbn\":\"987-654-321-0\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria"
                + " Montgomery\",\"year\":\"2005\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		Book result = objectMapper.readValue(json, Book.class);
		assertThat(result).isEqualTo(book);
	}
}
