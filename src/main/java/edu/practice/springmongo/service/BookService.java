package edu.practice.springmongo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.practice.springmongo.dao.BookDao;
import edu.practice.springmongo.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public ResponseEntity<Book> saveBook(Book book) throws IOException {
		book = bookDao.saveBook(book);
		book.setImageURL("/image/bookId/"+book.getId());
		return new ResponseEntity<Book> (book, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Book> findBook(String id) {
		Optional<Book> optional = bookDao.findBook(id);
		if(optional.isPresent()) {
			return new ResponseEntity<Book>(optional.get(), HttpStatus.FOUND);
		}else
		return null;
	}
	
	public ResponseEntity<List<Book>> findBookByName(String name) {
		List<Book> books = bookDao.findBookByName(name);
		if(books!=null) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.FOUND);
		}else
		return null;
	}

	public ResponseEntity<Book> updateBookById(String id, Book book) {
		Optional<Book> optional = bookDao.findBook(id);
		if(optional.isPresent()) {
			book.setId(id);
			book = bookDao.saveBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.FOUND);
		}else
		return null;
	}

	public ResponseEntity<Book> deleteBookById(String id) {
		Optional<Book> optional = bookDao.findBook(id);
		if(optional.isPresent()) {
			bookDao.deleteBook(optional.get());
			return new ResponseEntity<Book>(optional.get(), HttpStatus.FOUND);
		}else
		return null;
	}

	public ResponseEntity<List<Book>> findAllBooks() {
		List<Book> books = bookDao.findAllBooks();
		if(books!=null) {
			return new ResponseEntity<List<Book>>(books, HttpStatus.FOUND);
		}else
		return null;
	}
	
	
}
