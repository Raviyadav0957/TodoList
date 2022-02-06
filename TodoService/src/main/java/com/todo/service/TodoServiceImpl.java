package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.Todo;
import com.todo.repositories.TodoJpaRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoJpaRepository todoJpaRepo;

	public Todo createTodo(Todo todo) {
		return todoJpaRepo.save(todo);
	}

	public List<Todo> getAllTodos(String userId) {
		return todoJpaRepo.findByUserId(userId);
	}
	
	public Todo getTodo(String userId, long todoId) {
		return todoJpaRepo.findByUserIdAndTodoId(userId, todoId);
	}

	public List<Todo> deleteTodo(String userId, long todoId) {
		return todoJpaRepo.deleteByTodoIdAndUserId(todoId, userId);
	}

}
