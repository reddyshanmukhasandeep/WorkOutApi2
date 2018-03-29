package com.fsd.workout.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.workout.entities.CaloryTracker;
import com.fsd.workout.entities.WorkOutActive;
import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.repo.CaloryTrackerRepo;
import com.fsd.workout.repo.WorkOutActiveRepo;
import com.fsd.workout.repo.WorkOutCollectionRepo;

import ch.qos.logback.core.net.SyslogOutputStream;
@Service

public class WorkOutActiveServiceImpl implements WorkOutActiveService{
	
	@Autowired
	private CaloryTrackerRepo caloryTrackerRepo;
	 @Autowired
	 private WorkOutActiveRepo workOutActiveRepo;
   
	 @Autowired
	 private WorkOutCollectionRepo workOutColletionRepo;
	
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
		System.out.println(workout.getStartDate());
		if(workout.getStartDate() ==null)
		workout.setStartDate(LocalDate.now());
		
		
		return workOutActiveRepo.save(workout);
	}

	@Override
	public WorkOutActive updateWorkOut(WorkOutActive workOutActive) {
		
		if(workOutActive.getEndDate() ==null)
			workOutActive.setEndDate(LocalDate.now());
		
		Long workOutId =workOutActive.getWorkoutId();
		WorkOutCollection workOutCollection=workOutColletionRepo.findByWorkoutId(workOutId);
		Double cbm = (double)workOutCollection.getCbm();
		CaloryTracker caloryTracker = new CaloryTracker();
		LocalDate startDate =workOutActive.getStartDate();
		LocalTime startTime = workOutActive.getStartTime();
		LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
		System.out.println(startDate);
		LocalDate endDate =workOutActive.getEndDate();
		LocalTime endTime = workOutActive.getEndTime();
		LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);
	    long years = 	ChronoUnit.YEARS.between(startDateTime, endDateTime);
	    long weeks = 	ChronoUnit.WEEKS.between(startDateTime, endDateTime);
		long days = 	ChronoUnit.DAYS.between(startDateTime, endDateTime);
		long months= 	ChronoUnit.MONTHS.between(startDateTime, endDateTime);
		long hours = 	ChronoUnit.HOURS.between(startDateTime, endDateTime);
		long minutes = 	ChronoUnit.MINUTES.between(startDateTime, endDateTime);
		long seconds = 	ChronoUnit.SECONDS.between(startDateTime, endDateTime);
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println(minutes+"minutes");
		if(months>0)
		caloryTracker.setMonth(  Math.floor( (cbm*minutes/months)* 100) / 100);
		else 
			caloryTracker.setMonth((double) 0);
		
		if(years>0)
		caloryTracker.setYear( Math.floor((cbm*minutes/years)*100)/100);
		
		else 
			caloryTracker.setYear((double) 0);
		
		if(weeks>0)
		caloryTracker.setWeek(Math.floor(cbm*minutes/weeks)*100 /100);
		else
			caloryTracker.setWeek((double) 0);
		caloryTracker.setWorkOutActiveId(workOutActive.getWorkOutActiveId());
		
		caloryTrackerRepo.save(caloryTracker);
		return workOutActiveRepo.save(workOutActive);
	}

	@Override
	public void deleteWorkOut(Long id) {
		workOutActiveRepo.deleteById(id);
		
	}



	@Override
	public WorkOutActive getWorkOutDetailsByActiveId(Long id) {
		// TODO Auto-generated method stub
		return workOutActiveRepo.findByworkOutActiveId(id);
	}

	@Override
	public CaloryTracker getWorkOutActiveCalDetails(WorkOutActive workOutActive, Double cbm) {
		CaloryTracker caloryTracker = new CaloryTracker();
			LocalDate startDate =workOutActive.getStartDate();
			LocalTime startTime = workOutActive.getStartTime();
			LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
			System.out.println(startDate);
			LocalDate endDate =workOutActive.getEndDate();
			LocalTime endTime = workOutActive.getEndTime();
			LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);
			
			LocalDateTime tempDateTime = LocalDateTime.from( startDateTime );
			long years = tempDateTime.until( endDateTime, ChronoUnit.YEARS);
			tempDateTime = tempDateTime.plusYears( years );

			long months = tempDateTime.until( endDateTime, ChronoUnit.MONTHS);
			tempDateTime = tempDateTime.plusMonths( months );

			long days = tempDateTime.until( endDateTime, ChronoUnit.DAYS);
			tempDateTime = tempDateTime.plusDays( days );

			long hours = tempDateTime.until( endDateTime, ChronoUnit.HOURS);
			tempDateTime = tempDateTime.plusHours( hours );

			long minutes = tempDateTime.until( endDateTime, ChronoUnit.MINUTES);
			tempDateTime = tempDateTime.plusMinutes( minutes );
			 
			
			long seconds = tempDateTime.until( endDateTime, ChronoUnit.SECONDS);
			
			System.out.println(minutes+"minutes");
			caloryTracker.setMonth(cbm*months);
			caloryTracker.setYear(cbm*years);
			//caloryTracker.setWeek(weeks*cbm);
			caloryTracker.setWorkOutActiveId(workOutActive.getWorkOutActiveId());
			
			return caloryTrackerRepo.save(caloryTracker);
		}

	@Override
	public List<Object[]> MonthlyCal() {
		// TODO Auto-generated method stub
		return caloryTrackerRepo.totalMonthCal();
	}	
		
	
	
	

}
