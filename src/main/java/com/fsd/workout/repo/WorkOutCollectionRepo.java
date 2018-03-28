package com.fsd.workout.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.workout.entities.WorkOutActive;
import com.fsd.workout.entities.WorkOutCollection;

@Repository
public interface WorkOutCollectionRepo extends CrudRepository<WorkOutCollection,Long> {
 
	

	WorkOutCollection findByWorkoutId(Long id);
}
