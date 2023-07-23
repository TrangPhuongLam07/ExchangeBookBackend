package com.exchangeBook.ExchangeBook.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exchangeBook.ExchangeBook.entity.Image;
import com.exchangeBook.ExchangeBook.repository.ImageRepository;
import com.exchangeBook.ExchangeBook.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;

	@Value("${file.upload-dir}")
	private String uploadDir;

	@Override
	public Image uploadImage(MultipartFile file) {
		// Get file name
		String fileName = (new Date().getTime() / 1000) + file.getOriginalFilename();
		String filePath = uploadDir + fileName;

		// Create the directory if it does not exist.
		File directory = new File(uploadDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		// Save the file to the directory.
		try {
			file.transferTo(new File(filePath));
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.size(file.getSize()).path(filePath).build());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Image> uploadMultiImage(MultipartFile[] images) {
		return Arrays.asList(images).stream().map((image) -> uploadImage(image)).collect(Collectors.toList());
	}

	@Override
	public byte[] downloadImage(String fileName) {
		Image image = imageRepository.findByName(fileName);
		try {
			return Files.readAllBytes(new File(image.getPath()).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<byte[]> downloadMultiImage(String[] imagesName) {
		return Arrays.asList(imagesName).stream().map(this::downloadImage).collect(Collectors.toList());
	}

	@Override
	public void deleteImage(String fileName) {
		try {
			Files.delete(Paths.get(uploadDir).resolve(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
