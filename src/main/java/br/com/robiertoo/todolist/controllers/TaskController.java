package br.com.robiertoo.todolist.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robiertoo.todolist.model.entities.Task;
import br.com.robiertoo.todolist.model.repositories.TaskRepository;

@RestController
@RequestMapping("/api/items")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/{id}")
	public Optional<Task> showTask(@PathVariable int id) {
		return taskRepository.findById(id);
	}
	
	@GetMapping
	public Iterable<Task> showTasks() {
		return taskRepository.findAll();
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Task createTask(@Valid Task task) {
		taskRepository.save(task);
		return task;
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id) {
		taskRepository.deleteById(id);
	}
	
	@PutMapping("/{id}/complete")
	public Optional<Task> completeTask(@PathVariable int id) {
		taskRepository.completeTask(id);
		return taskRepository.findById(id);
	}
}
