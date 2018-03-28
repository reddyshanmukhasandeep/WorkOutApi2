package com.fsd.workout.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.workout.entities.Category;


@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {

}
