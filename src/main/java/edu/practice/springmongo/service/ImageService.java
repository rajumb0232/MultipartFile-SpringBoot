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

import edu.practice.springmongo.dao.BookDao;
import edu.practice.springmongo.dao.ImageDao;
import edu.practice.springmongo.model.Book;
import edu.practice.springmongo.model.Image;

@Service
public class ImageService {
	
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private BookDao bookDao;
	
	public ResponseEntity<byte[]> getImageById(String imageId) {
		Optional<Image> optional = imageDao.getImage(imageId);
		if(optional.isPresent()) {
			Image image = optional.get();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
					.contentLength(image.getImageBytes().length)
					.body(image.getImageBytes());
		}else {
			return null;
		}
	}
	
	public ResponseEntity<String> saveImage(MultipartFile image, String bookId) throws IOException{
		Optional<Book> optional = bookDao.findBook(bookId);
		if(optional.isPresent()) {
				Image newImage = new Image();
				newImage.setImageBytes(image.getBytes());
				newImage.setBookId(bookId);
				newImage = imageDao.saveImage(newImage);
				return new ResponseEntity<String>("Image saved Successfully!!", HttpStatus.CREATED);
		}else {
			return null;
		}
		
	}

	public ResponseEntity<List<String>> getImagesByBookId(String bookId) {
		Optional<List<Image>> optional = imageDao.getImagesByBookId(bookId);
		if(optional.isPresent()) {
			List<Image> images = optional.get();
			List<String> ImageURLs = new ArrayList<>();
			for(Image image : images) {
				ImageURLs.add("/image/id/"+image.getImageId());
			}
			return new ResponseEntity<List<String>>(ImageURLs, HttpStatus.FOUND);
		}else {
			return null;
		}
	}

}
