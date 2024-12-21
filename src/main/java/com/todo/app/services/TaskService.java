package com.todo.app.services;

import com.todo.app.models.Task;
import com.todo.app.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	private final TaskRepo taskRepo;

	public TaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}

	public List<Task> getAllTasks() {
		return this.taskRepo.findAll();
	}

	public void createTask(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		this.taskRepo.save(task);
	}

	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		this.taskRepo.deleteById(id);

	}

	public void toggleTasks(Long id) {
		// TODO Auto-generated method stub

		Task task = this.taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid task id"));
		task.setCompleted(!task.getCompleted());

		this.taskRepo.save(task);

	}

}
