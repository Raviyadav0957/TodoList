package com.todo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo.exceptions.AbstractErrorResponse;

@Entity
@Table(name = "todo")
public class Todo extends AbstractErrorResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long todoId;
	private String userId;
	private String description;
	private Date targetDate;
	private boolean isCompleted;

	protected Todo() {
	}

	public Todo(long todoId, String userId, String description, Date targetDate, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.userId = userId;
		this.description = description;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + todoId + ", userId=" + userId + ", description=" + description + ", targetDate=" + targetDate
				+ ", isDone=" + isCompleted + "]";
	}

}
