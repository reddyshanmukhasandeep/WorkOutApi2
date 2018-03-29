package com.fsd.workout.service;

import java.util.List;

import com.fsd.workout.entities.CaloryTracker;
import com.fsd.workout.entities.WorkOutActive;

public interface WorkOutActiveService {

	List<WorkOutActive> getWorkOutActiveDetails();

	WorkOutActive getWorkOutDetailsById(Long id);

	WorkOutActive addWorkOut(WorkOutActive workout);

	WorkOutActive updateWorkOut(WorkOutActive workout);

	void deleteWorkOut(Long id);

	

	CaloryTracker getWorkOutActiveCalDetails(WorkOutActive workOutActive, Double cbm);

	WorkOutActive getWorkOutDetailsByActiveId(Long id);

	List<Object[]> MonthlyCal();
	

}
