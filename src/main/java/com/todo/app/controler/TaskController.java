package com.todo.app.controler;

import com.todo.app.models.Task;
import com.todo.app.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}

	@PostMapping
	public String createTask(@RequestParam String title) {
		this.taskService.createTask(title);
		return "redirect:/";
	}

	@GetMapping("/{id}/delete")
	public String deleteTasks(@PathVariable Long id) {
		this.taskService.deleteTask(id);
		return "redirect:/";
	}

	@GetMapping("/{id}/toggle")
	public String toggleTasks(@PathVariable Long id) {
		this.taskService.toggleTasks(id);
		return "redirect:/";
	}
}
