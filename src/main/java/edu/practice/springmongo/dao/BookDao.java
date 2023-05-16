package edu.practice.springmongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.practice.springmongo.model.Book;
import edu.practice.springmongo.repo.BookRepo;

@Repository
public class BookDao {
	
	@Autowired
	private BookRepo bookRepo;
	
	public Book saveBook(Book book) {
		return bookRepo.insert(book);
	}
	
	public Book findBook(String id) {
		return bookRepo.findById(id).get();
	}
	
	public List<Book> findBookByName(String name) {
		return bookRepo.findBookBYName(name);
	}
}
