package edu.practice.springmongo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.practice.springmongo.model.BookPdf;
import edu.practice.springmongo.repo.PdfRepo;

@Repository
public class PdfDao {
	
	@Autowired
	private PdfRepo pdfRepo;
	
	public BookPdf saveBookPdf(BookPdf bookPdf) {
		return pdfRepo.save(bookPdf);
	}
	
	public Optional<BookPdf> getPdfById(String pdfId) {
		return pdfRepo.findById(pdfId);
	}
	
	public Optional<List<BookPdf>> getAllPdfByBookId(String bookId) {
		return pdfRepo.findAllByBookId(bookId);
	}
}
