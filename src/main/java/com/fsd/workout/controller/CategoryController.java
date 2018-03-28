package com.fsd.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.workout.entities.Category;
import com.fsd.workout.service.CategoryService;

@RestController
@RequestMapping("/api/category/")
@CrossOrigin
public class CategoryController {

	@Autowired
	private  CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getCategoryDetails(){
		List<Category> category = categoryService.getCategoryDetails();
		return new ResponseEntity<List<Category>>(category,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> postCategory(@RequestBody Category category){
		
		Category categoryDetail = categoryService.addCategory(category);
		return new ResponseEntity<Category>(categoryDetail,HttpStatus.OK);
	}
	@PutMapping("/")
	public ResponseEntity<Category> putCategory(@RequestBody Category category){
		
		Category categoryDetail = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(categoryDetail,HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
		
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	 
}
