package edu.practice.springmongo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.practice.springmongo.model.Book;
import edu.practice.springmongo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws IOException {
		return bookService.saveBook(book);
	}
	
	@GetMapping
	public ResponseEntity<Book> findBook(String id) {
		return bookService.findBook(id);
	}
	
	@GetMapping("/bookName/{name}")
	public ResponseEntity<List<Book>> findBookById(@PathVariable String name){
		return bookService.findBookByName(name);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> findAllBooks(){
		return bookService.findAllBooks();
	}
	
	@PutMapping("/bookId/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable String id,
			@RequestBody Book book){
		return bookService.updateBookById(id, book);
	}
	
	@DeleteMapping("/bookId/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable String id){
		return bookService.deleteBookById(id);
	}
}
