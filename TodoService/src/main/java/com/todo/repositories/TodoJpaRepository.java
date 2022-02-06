package com.todo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entities.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByUserId(String userId);

	Todo findByUserIdAndTodoId(String userId, long todoId);
	
	@Transactional
	List<Todo> deleteByTodoIdAndUserId(long todoId, String userId);
}
