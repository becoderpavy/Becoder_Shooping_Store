package com.ecom.service;

import java.util.List;

import com.ecom.dto.CategoryDto;
import com.ecom.exception.ResourceNotFoundException;

public interface CategoryService {

	public CategoryDto saveCategory(CategoryDto category) throws Exception;

	public List<CategoryDto> getIsActiveCategory();

	public List<CategoryDto> getAllCategory();

	public CategoryDto getCategoryById(Integer id);

	public Boolean deleteCategory(Integer id);

	public Boolean existCategory(String category);

}
