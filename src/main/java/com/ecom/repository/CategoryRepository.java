package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Boolean existsByName(String category);

	Boolean existsByIdAndName(Integer id, String name);

}
