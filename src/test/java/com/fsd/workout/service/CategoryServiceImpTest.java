package com.fsd.workout.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fsd.workout.entities.Category;
import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.repo.CategoryRepo;

public class CategoryServiceImpTest {

	@InjectMocks
	private CategoryServiceImpl service;
	public static final String PATH = "/api/category/";
	private String categoryName = "category";
	
 
	 @Mock
	 private CategoryRepo repository;
	 
	 private Category category = new Category(categoryName);
	 
	 @Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
		}
	 @Test
		public void thatGetListOfStagesWhenRequestAllStages() {
			// Given
			List<Category> mockData = new ArrayList<>();
			mockData.add(category);
			when(repository.findAll()).thenReturn(mockData);
			List<Category> list = service.getCategoryDetails();
			assertEquals(1, list.size());
		}
}
