package com.fsd.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.workout.entities.WorkOutActive;
import com.fsd.workout.repo.WorkOutActiveRepo;
@Service
public class WorkOutActiveServiceImpl implements WorkOutActiveService{

	 @Autowired
	 private WorkOutActiveRepo workOutActiveRepo;
	@Override
	public List<WorkOutActive> getWorkOutActiveDetails() {
		// TODO Auto-generated method stub
		return (List<WorkOutActive>) workOutActiveRepo.findAll();
	}

	@Override
	public WorkOutActive getWorkOutDetailsById(Long id) {
		// TODO Auto-generated method stub
		return workOutActiveRepo.findByworkoutId(id);
	}

	@Override
	public WorkOutActive addWorkOut(WorkOutActive workout) {
		// TODO Auto-generated method stub
		return workOutActiveRepo.save(workout);
	}

	@Override
	public WorkOutActive updateWorkOut(WorkOutActive workout) {
		// TODO Auto-generated method stub
		return workOutActiveRepo.save(workout);
	}

	@Override
	public void deleteWorkOut(Long id) {
		workOutActiveRepo.deleteById(id);
		
	}

}
