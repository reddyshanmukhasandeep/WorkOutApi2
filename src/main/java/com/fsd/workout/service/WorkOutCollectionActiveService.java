package com.fsd.workout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.workout.entities.WorkOutCollection;

public interface WorkOutCollectionActiveService {

	 List<WorkOutCollection> getWorkOutActiveDetails();

	WorkOutCollection addWorkOut(WorkOutCollection workout);

	WorkOutCollection updateWorkOut(WorkOutCollection workout);

	void deleteWorkOut(Long id);

	WorkOutCollection getWorkOutDetailsById(Long id);

}
