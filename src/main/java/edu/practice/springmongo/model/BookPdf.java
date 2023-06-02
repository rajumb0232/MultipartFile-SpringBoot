package edu.practice.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "pdfs")
public class BookPdf {
	@Id
	private String pdfId;
	private byte[] pdfData;
	private String bookId;
	
}
