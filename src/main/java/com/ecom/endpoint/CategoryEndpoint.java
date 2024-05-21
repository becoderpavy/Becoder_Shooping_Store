package com.ecom.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.dto.CategoryDto;

public interface CategoryEndpoint {

	@PostMapping("/saveCategory")
	public ResponseEntity<?> saveCategoryWithImage(@RequestPart("file") MultipartFile file,
			@RequestParam("category") String category) throws Exception;

	@PostMapping("/")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) throws Exception;

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) throws Exception;

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory();

}
