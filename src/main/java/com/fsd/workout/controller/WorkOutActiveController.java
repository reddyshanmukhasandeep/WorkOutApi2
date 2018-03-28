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

import com.fsd.workout.entities.WorkOutActive;
import com.fsd.workout.service.WorkOutActiveService;
@RestController
@RequestMapping("/api/workoutactive/")
@CrossOrigin
public class WorkOutActiveController {
	

		@Autowired
		private  WorkOutActiveService workOutActiveService;
		
		@GetMapping("/")
		public ResponseEntity<List<WorkOutActive>> getWorkOutActiveDetails(){
			
			List<WorkOutActive> workOutActive = workOutActiveService.getWorkOutActiveDetails();
			return new ResponseEntity<List<WorkOutActive>>(workOutActive,HttpStatus.OK);
		}
		
		@GetMapping(value="{id}")
		public ResponseEntity<WorkOutActive> getWorkOutActiveDetails(@PathVariable("id") Long id){
			
			WorkOutActive workOutActive = workOutActiveService.getWorkOutDetailsById(id);
			return new ResponseEntity<WorkOutActive>(workOutActive,HttpStatus.OK);
		}
		
		
		
		@PostMapping("/")
		public ResponseEntity<WorkOutActive> postWorkOut(@RequestBody WorkOutActive workout){
			System.out.println("inisde post collection");
			System.out.println(workout);
			WorkOutActive WorkOutCollectionDetail = workOutActiveService.addWorkOut(workout);
			return new ResponseEntity<WorkOutActive>(WorkOutCollectionDetail,HttpStatus.OK);
		}
		@PutMapping("/")
		public ResponseEntity<WorkOutActive> putWorkOut(@RequestBody WorkOutActive workout){
			
			WorkOutActive categoryDetail = workOutActiveService.updateWorkOut(workout);
			return new ResponseEntity<WorkOutActive>(categoryDetail,HttpStatus.OK);
		}
		@DeleteMapping(value="{id}")
		public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
			
			
			workOutActiveService.deleteWorkOut(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

}
