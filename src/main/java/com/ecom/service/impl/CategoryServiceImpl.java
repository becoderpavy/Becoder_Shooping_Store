package com.ecom.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.ecom.dto.CategoryDto;
import com.ecom.exception.ExistResourceException;
import com.ecom.exception.ResourceNotFoundException;
import com.ecom.model.Category;
import com.ecom.repository.CategoryRepository;
import com.ecom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) throws Exception {

		Category category = mapper.map(categoryDto, Category.class);
		category.setName(category.getName().trim());

		CategoryDto saveCategoryDto = null;
		setUserDetails(category);
		if (ObjectUtils.isEmpty(category.getId())) {
			// new
			Boolean existCategory = existCategory(category.getName().trim());
			if (existCategory) {
				throw new ExistResourceException("Category already exists");
			}
			Category saveCategory = categoryRepository.save(category);
			saveCategoryDto = mapper.map(saveCategory, CategoryDto.class);

		} else {
			// update

			Category existCategory = categoryRepository.findById(category.getId()).orElse(null);

			// Id is valid or not
			if (existCategory == null) {
				throw new ResourceNotFoundException("Category not found with Id=" + category.getId());
			}

			// check id with name exist
			Boolean existIdAndName = existIdAndCategory(category.getId(), category.getName());

			if (!existIdAndName) {
				Boolean existCategoryName = existCategory(category.getName().trim());
				if (existCategoryName) {
					throw new ExistResourceException("Category already exists");
				}
			}

			if (StringUtils.hasLength(category.getName())) {
				existCategory.setName(category.getName());
			}
			if (StringUtils.hasLength(category.getDescription())) {
				existCategory.setDescription(category.getDescription());
			}
			if (category.getIsActive() != null) {
				existCategory.setIsActive(category.getIsActive());
			}
			if (category.getIsDeleted() != null) {
				existCategory.setIsDeleted(category.getIsDeleted());
			}
			if (category.getIsFeatures() != null) {
				existCategory.setIsFeatures(category.getIsFeatures());
			}
			if (StringUtils.hasLength(category.getImages())) {
				existCategory.setImages(category.getImages());
			}
			existCategory.setUpdatedBy(category.getUpdatedBy());
			existCategory.setUpdatedDate(category.getUpdatedDate());
			Category updateCategory = categoryRepository.save(existCategory);
			saveCategoryDto = mapper.map(updateCategory, CategoryDto.class);
		}
		return saveCategoryDto;
	}

	private Boolean existIdAndCategory(Integer id, String name) {
		return categoryRepository.existsByIdAndName(id, name);
	}

	private void setUserDetails(Category category) {
		if (ObjectUtils.isEmpty(category.getId())) {
			category.setCreatedBy(1);
			category.setCreatedDate(new Date());
			category.setUpdatedBy(null);
		} else {
			category.setUpdatedBy(2);
			category.setUpdatedDate(new Date());
		}
	}

	@Override
	public List<CategoryDto> getIsActiveCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existCategory(String category) {
		return categoryRepository.existsByName(category);
	}

}
