package com.fsd.workout.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calorytracker")
public class CaloryTracker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="activetrackerId")
	private Long activetrackerId;
	
	@Column(name="week")
	private Double week;
	
	@Column(name="month")

	private Double month;
	@Column(name="year")

	private Double year;
	@Column(name="workOutActiveId")
	private Long workOutActiveId;
	public Long getActivetrackerId() {
		return activetrackerId;
	}
	public Double getWeek() {
		return week;
	}
	public void setWeek(Double week) {
		this.week = week;
	}
	public Double getMonth() {
		return month;
	}
	public void setMonth(Double month) {
		this.month = month;
	}
	public Double getYear() {
		return year;
	}
	public void setYear(Double year) {
		this.year = year;
	}
	public Long getWorkOutActiveId() {
		return workOutActiveId;
	}
	public void setWorkOutActiveId(Long workOutActiveId) {
		this.workOutActiveId = workOutActiveId;
	}
	public void setActivetrackerId(Long activetrackerId) {
		this.activetrackerId = activetrackerId;
	}
	public CaloryTracker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
