package edu.practice.springmongo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.practice.springmongo.service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfController {
	
	@Autowired
	private PdfService pdfService;
	
	@PostMapping("/bookId/{bookId}")
	public ResponseEntity<String> savePdf(@RequestParam MultipartFile pdf,
			@PathVariable String bookId) throws IOException{
		return pdfService.savePdf(pdf, bookId);
	}
	
	@GetMapping("/pdfId/{pdfId}")
	public ResponseEntity<byte[]> getPdfById(@PathVariable String pdfId){
		return pdfService.getPdfById(pdfId);
	}
	
	@GetMapping("/bookId/{bookId}")
	public ResponseEntity<List<String>> getPdfUrls(@PathVariable String bookId){
		return pdfService.getPdfUrls(bookId);
	}
}
