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

import edu.practice.springmongo.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping("/id/{imageId}")
	public ResponseEntity<byte[]> getImageById(@PathVariable String imageId){
		return imageService.getImageById(imageId);
	}
	
	@PostMapping("/bookId/{bookId}")
	public ResponseEntity<String> saveImages(
			@RequestParam MultipartFile image, @PathVariable String bookId) throws IOException{
		return imageService.saveImage(image, bookId);
	}
	
	@GetMapping("/bookId/{bookId}")
	public ResponseEntity<List<String>> getImagesByBookId(
			@PathVariable String bookId){
		return imageService.getImagesByBookId(bookId);
	}
	
	
}
