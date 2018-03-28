package com.fsd.workout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.workout.entities.Category;


public interface CategoryService {

	

	List<Category> getCategoryDetails();

	Category addCategory(Category category);

	Category updateCategory(Category category);


	void deleteCategory(Long id);

}
