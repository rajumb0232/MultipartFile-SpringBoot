package edu.practice.springmongo.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
	
	private String id;
	private String name;
	private int pages;
	private String author;
	@JsonIgnore
	private MultipartFile image;
}
