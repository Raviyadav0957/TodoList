package com.todo.service;

import java.util.List;

import com.todo.entities.Todo;

public interface TodoService {
	
	public Todo createTodo(Todo todo);

	public List<Todo> getAllTodos(String userId);
	
	public Todo getTodo(String userId, long todoId);

	public List<Todo> deleteTodo(String userId, long todoId);

}
