package edu.practice.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Images")
public class Image {
	
	@Id
	private String imageId;
	private String bookId;
	private byte[] imageBytes;
}
