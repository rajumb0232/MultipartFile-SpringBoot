package edu.practice.springmongo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.practice.springmongo.model.Image;
import edu.practice.springmongo.repo.ImageRepo;
@Repository
public class ImageDao {
	
	@Autowired
	private ImageRepo imageRepo;
	
	public Image saveImage(Image image) {
		return imageRepo.save(image);
	}
	
	public Optional<Image> getImage(String imageId) {
		return imageRepo.findById(imageId);
	}

	public Optional<List<Image>> getImagesByBookId(String bookId) {
		return imageRepo.findAllByBookId(bookId);
	}
}
