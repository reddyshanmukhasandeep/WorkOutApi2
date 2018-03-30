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

import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.repo.WorkOutCollectionRepo;
import com.fsd.workout.service.WorkOutCollectionServiceImp;

public class WorkCollectionServiceImpTest {

	@InjectMocks
	private WorkOutCollectionServiceImp service;
	public static final String PATH = "/api/workout/";
	private String title= "title";
	private String note = "note";
	private Float cbm = 2.2f;
	private Long categoryId =1l;	
	private static final int SOME_ID = 1;
 
	 @Mock
	 private WorkOutCollectionRepo repository;
	 
	 private WorkOutCollection workOutCollection = new WorkOutCollection(1l,title,note,cbm,categoryId);
	 
	 @Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
		}
	 @Test
		public void thatGetListOfStagesWhenRequestAllStages() {
			// Given
			List<WorkOutCollection> mockData = new ArrayList<>();
			mockData.add(workOutCollection);
			when(repository.findAll()).thenReturn(mockData);
			List<WorkOutCollection> list = service.getWorkOutActiveDetails();
			assertEquals(1, list.size());
		}
}
