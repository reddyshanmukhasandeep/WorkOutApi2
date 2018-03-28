package com.fsd.workout.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="workout_active")

public class WorkOutActive{
 
	@Id
	@Column(name="workOut_active_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workOutActiveId;
	
	@Column(name="start_date")
	private LocalDate  startDate;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="status")
	private boolean status;
	
	
	private Long workoutId;
	
	

	public Long getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public Long getWorkOutActiveId() {
		return workOutActiveId;
	}
	public void setWorkOutActiveId(Long workOutActiveId) {
		this.workOutActiveId = workOutActiveId;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public WorkOutActive() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WorkOutActive [workOutActiveId=" + workOutActiveId + ", startDate=" + startDate + ", startTime="
				+ startTime + ", endDate=" + endDate + ", endTime=" + endTime + ", comment=" + comment + ", status="
				+ status + ", workoutId=" + workoutId + "]";
	}
	
	

	

	
	
}
