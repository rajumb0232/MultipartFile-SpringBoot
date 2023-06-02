package edu.practice.springmongo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.practice.springmongo.dao.PdfDao;
import edu.practice.springmongo.model.BookPdf;

@Service
public class PdfService {
	
	@Autowired
	private PdfDao pdfDao;

	public ResponseEntity<String> savePdf(MultipartFile pdf, String bookId) throws IOException {
		BookPdf bookPdf = new BookPdf();
		bookPdf.setPdfData(pdf.getBytes());
		bookPdf.setBookId(bookId);
		pdfDao.saveBookPdf(bookPdf);
		return new ResponseEntity<String>("PDF file saved successfully!", HttpStatus.CREATED);
	}

	public ResponseEntity<byte[]> getPdfById(String pdfId) {
		Optional<BookPdf> optional = pdfDao.getPdfById(pdfId);
		if(optional.isPresent()) {
			BookPdf bookPdf = optional.get();
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
					.contentLength(bookPdf.getPdfData().length).body(bookPdf.getPdfData());
		}else {
			return null;
		}
	}

	public ResponseEntity<List<String>> getPdfUrls(String bookId) {
		Optional<List<BookPdf>> optional = pdfDao.getAllPdfByBookId(bookId);
		if(optional.isPresent()) {
			List<BookPdf> pdfs = optional.get();
			List<String> pdfUrls = new ArrayList<>();
			for(BookPdf pdf : pdfs) {
				pdfUrls.add("/pdf/pdfId/"+pdf.getPdfId());
			}
			return new ResponseEntity<List<String>>(pdfUrls, HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	
	

	
	
}
