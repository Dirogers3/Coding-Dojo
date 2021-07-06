package com.ianrogers.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianrogers.beltexam.models.Task;
import com.ianrogers.beltexam.models.User;
import com.ianrogers.beltexam.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository tr;
	
	public List<Task> allTasks() {
		return tr.findAll();
	}
	
	public Task findtask(Long id) {
		Optional<Task> optionalTask = tr.findById(id);
		if(optionalTask.isPresent()) {
			return optionalTask.get();
		} else {
			return null;
		}
	}
	
	public Task createTask(Task task) {
		return tr.save(task);
	}
	
	public Task updateTask(Long id, String name, User user, String assignee, String priority) {
		Task t = findtask(id);
		t.setName(name);
		t.setUser(user);
		t.setAssignee(assignee);
		t.setPriority(priority);
		return tr.save(t);
	}
	
	public void delete(Long id) {
		tr.deleteById(id);
	}
}
