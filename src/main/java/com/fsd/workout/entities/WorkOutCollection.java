package com.fsd.workout.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="workout_collection")
public class WorkOutCollection  {
  
	@Id
	@Column(name="workout_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long workoutId;
	
	@Column(name="workout_title")
	private String title;
	
	@Column(name="workout_note")
	private String note;
	@Column(name="calories_burn_per_min", precision=4,scale=2)
	private float cbm;
	
	private Long categoryId;
	
	
	
	

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getCbm() {
		return cbm;
	}

	public void setCbm(float cbm) {
		this.cbm = cbm;
	}

	



	
	public WorkOutCollection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
