package edu.practice.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "books")
@JsonInclude(value = Include.NON_NULL)
public class Book {
	
	@Id
	private String id;
	private String name;
	private int pages;
	private String author;
	private String ImageURL;
}
