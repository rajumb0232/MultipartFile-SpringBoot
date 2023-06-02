//package edu.practice.springmongo.service;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//public class ByteToMultipartFile implements MultipartFile {
//
//	private byte[] imageData;
//	private String name;
//	private String originalFilename;
//	private String imageType;
//
//	public ByteToMultipartFile(byte[] imageData, String name, String originalFilename, String imageType) {
//		this.imageData = imageData;
//		this.name = name;
//		this.originalFilename = originalFilename;
//		this.imageType = imageType;
//	}
//
//	@Override
//	public String getName() {
//		return name;
//	}
//
//	@Override
//	public String getOriginalFilename() {
//		return originalFilename;
//	}
//
//	@Override
//	public String getContentType() {
//		return imageType;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return imageData.length == 0;
//	}
//
//	@Override
//	public long getSize() {
//		return imageData.length;
//	}
//
//	@Override
//	public byte[] getBytes() throws IOException {
//		return imageData;
//	}
//
//	@Override
//	public InputStream getInputStream() throws IOException {
//		return new ByteArrayInputStream(imageData);
//	}
//
//	@Override
//	public void transferTo(java.io.File dest) throws IOException, IllegalStateException {
//		throw new UnsupportedOperationException("Transfer to file is not supported.");
//	}
//
//}
