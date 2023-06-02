package edu.practice.springmongo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.practice.springmongo.model.Image;

public interface ImageRepo extends MongoRepository<Image, String> {

	public Optional<List<Image>> findAllByBookId(String bookId);
	
}
