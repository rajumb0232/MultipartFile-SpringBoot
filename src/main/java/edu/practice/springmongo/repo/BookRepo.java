package edu.practice.springmongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.practice.springmongo.model.Book;

public interface BookRepo extends MongoRepository<Book, String> {
	
	@Query("{'name':?0}")
	public List<Book> findBookBYName(String name);
}
