package com.fsd.workout.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fsd.workout.entities.CaloryTracker;

public interface CaloryTrackerRepo extends JpaRepository<CaloryTracker,Long> {
	
	@Query(value="SELECT  SUM(CT.month),SUM(CT.week),SUM(CT.year) FROM calorytracker CT", nativeQuery = true)
	public List<Object[]> totalMonthCal();
	
	@Query(value="SELECT activetrackerId, SUM(weekCaloriesBurnt) FROM CaloryTracker group by activetrackerId", nativeQuery = true)
	public CaloryTracker totalWeekCal();
	
	@Query(value="SELECT activetrackerId, SUM(yearCaloriesBurnt) from CaloryTracker"
			+ " group by activetrackerId ", nativeQuery = true)
	public CaloryTracker totalYearCal();
}
