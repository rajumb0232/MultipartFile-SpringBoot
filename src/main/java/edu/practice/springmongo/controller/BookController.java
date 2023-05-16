package edu.practice.springmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.practice.springmongo.dao.BookDao;
import edu.practice.springmongo.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return bookDao.saveBook(book);
	}
	
	@GetMapping
	public Book findBook(String id) {
		return bookDao.findBook(id);
	}
	
	@GetMapping("/{name}")
	public List<Book> findBookById(@PathVariable String name){
		return bookDao.findBookByName(name);
	}
}
