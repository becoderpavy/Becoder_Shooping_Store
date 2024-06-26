package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.dto.CategoryDto;
import com.ecom.endpoint.CategoryEndpoint;
import com.ecom.exception.ExistResourceException;
import com.ecom.exception.ResourceNotFoundException;
import com.ecom.service.CategoryService;
import com.ecom.service.FileService;
import com.ecom.utils.CommonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryEndpoint {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FileService fileService;

	@Value("${category.imges}")
	private String categoryImagePath;

	@Override
	public ResponseEntity<?> saveCategory(CategoryDto categoryDto) throws ResourceNotFoundException {
		CategoryDto saveCategoryDto = null;
		try {

			saveCategoryDto = categoryService.saveCategory(categoryDto);

		} catch (ExistResourceException e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.CONFLICT);
		} catch (ResourceNotFoundException e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return CommonUtils.createBuildResponse("success", saveCategoryDto, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> saveCategoryWithImage(MultipartFile file, String category)
			throws ResourceNotFoundException {
		CategoryDto saveCategoryDto = null;
		try {

			ObjectMapper mapper = new ObjectMapper();
			// conversion : String to java Object
			CategoryDto categoryDto = mapper.readValue(category, CategoryDto.class);

			log.info("category : {}", categoryDto);
			log.info("File : {}", file.getOriginalFilename());

			// String imageName = file.isEmpty() ? "" : file.getOriginalFilename();
			// categoryDto.setImages(imageName);
			if (!file.isEmpty()) {
				// file upload local folder either s3 bucket cloud
				String uploadFileName = fileService.uploadFile(file, categoryImagePath);
				categoryDto.setImages(uploadFileName);
			}
			saveCategoryDto = categoryService.saveCategory(categoryDto);

		} catch (ExistResourceException e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.CONFLICT);
		} catch (ResourceNotFoundException e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return CommonUtils.createBuildResponse("success", saveCategoryDto, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> deleteCategory(Integer id) throws Exception {

		Boolean deleteCategory = null;
		try {
			deleteCategory = categoryService.deleteCategory(id);
			if (!deleteCategory) {
				return CommonUtils.createBuildResponse("failed", "Not Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ResourceNotFoundException e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.error("Error :{}", e.getMessage());
			return CommonUtils.createBuildResponse("failed", e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return CommonUtils.createBuildResponse("success", "Delete Sucess", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllCategory() {
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return CommonUtils.createBuildResponse("success", allCategory, HttpStatus.OK);
	}

}
