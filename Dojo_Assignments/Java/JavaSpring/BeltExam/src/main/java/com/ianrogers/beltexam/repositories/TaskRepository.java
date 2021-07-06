package com.ianrogers.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianrogers.beltexam.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	 List<Task> findAll();
}
