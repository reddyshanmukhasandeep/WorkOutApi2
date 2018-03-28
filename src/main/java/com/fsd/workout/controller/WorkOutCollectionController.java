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

import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.service.WorkOutCollectionActiveService;

@RestController
@RequestMapping("/api/workout/")
@CrossOrigin
public class WorkOutCollectionController {
	@Autowired
	private  WorkOutCollectionActiveService workOutCollectionService;
	
	@GetMapping("/")
	public ResponseEntity<List<WorkOutCollection>> getCategoryDetails(){
		
		List<WorkOutCollection> WorkOutCollection = workOutCollectionService.getWorkOutActiveDetails();
		return new ResponseEntity<List<WorkOutCollection>>(WorkOutCollection,HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<WorkOutCollection> getCategoryDetails(@PathVariable("id") Long id){
		
		WorkOutCollection workOutCollection = workOutCollectionService.getWorkOutDetailsById(id);
		return new ResponseEntity<WorkOutCollection>(workOutCollection,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/")
	public ResponseEntity<WorkOutCollection> postWorkOut(@RequestBody WorkOutCollection workout){
		System.out.println("inisde post collection");
		System.out.println(workout);
		WorkOutCollection WorkOutCollectionDetail = workOutCollectionService.addWorkOut(workout);
		return new ResponseEntity<WorkOutCollection>(WorkOutCollectionDetail,HttpStatus.OK);
	}
	@PutMapping("/")
	public ResponseEntity<WorkOutCollection> putWorkOut(@RequestBody WorkOutCollection workout){
		
		WorkOutCollection categoryDetail = workOutCollectionService.updateWorkOut(workout);
		return new ResponseEntity<WorkOutCollection>(categoryDetail,HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
		
		
		workOutCollectionService.deleteWorkOut(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
