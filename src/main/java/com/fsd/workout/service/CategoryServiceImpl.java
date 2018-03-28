package com.fsd.workout.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.workout.entities.Category;
import com.fsd.workout.repo.CategoryRepo;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    
	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public List<Category> getCategoryDetails() {
				
		  return  (List<Category>) categoryRepo.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
		
	}



}
