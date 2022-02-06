package com.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.Todo;
import com.todo.service.TodoService;

@CrossOrigin
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;

	@GetMapping("/getAllTodos")
	public List<Todo> getAllTodos(@RequestHeader String userId){
		return todoService.getAllTodos(userId);
	}
	
	@GetMapping("/getTodo")
	public Todo getTodo(@RequestHeader String userId, @RequestParam long todoId){
		return todoService.getTodo(userId, todoId);
	}
	
	@PostMapping("/createTodo")
	public Todo createTodo(@RequestBody Todo todo){
		return todoService.createTodo(todo);
	}
	
	@DeleteMapping("/deleteTodo")
	public List<Todo> deleteTodo(@RequestHeader String userId, @RequestParam long todoId){
		return todoService.deleteTodo(userId, todoId);
	}

}
