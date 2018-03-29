package com.fsd.workout.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.repo.WorkOutCollectionRepo;
@Service
@Transactional
public class WorkOutCollectionServiceImp implements WorkOutCollectionActiveService {
 
	 @Autowired
	 private WorkOutCollectionRepo workOutRepo;
	@Override
	public List<WorkOutCollection> getWorkOutActiveDetails() {
		// TODO Auto-generated method stub
		return (List<WorkOutCollection>) workOutRepo.findAll();
	}

	@Override
	@Transactional
	public WorkOutCollection addWorkOut(WorkOutCollection workout) {
		// TODO Auto-generated method stub
		return workOutRepo.save(workout);
	}

	@Override
	public WorkOutCollection updateWorkOut(WorkOutCollection workout) {
		// TODO Auto-generated method stub
//		WorkOutCollection	updatedworkout = workOutRepo.findByWorkoutId(workout.getWorkoutId());
//		updatedworkout.setTitle(workout.getTitle());
//		updatedworkout.setNote(workout.getNote());
//		updatedworkout.setCbm(workout.getCbm());
		
		return workOutRepo.save(workout);
	}

	@Override
	public void deleteWorkOut(Long id) {
		workOutRepo.deleteById(id);
		
	}

	@Override
	public  WorkOutCollection getWorkOutDetailsById(Long id) {
		// TODO Auto-generated method stub
		return workOutRepo.findByWorkoutId(id);
	}

	
}
