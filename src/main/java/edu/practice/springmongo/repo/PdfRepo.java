package edu.practice.springmongo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.practice.springmongo.model.BookPdf;

public interface PdfRepo extends MongoRepository<BookPdf, String>{
	
	public Optional<List<BookPdf>> findAllByBookId(String bookId);
}
