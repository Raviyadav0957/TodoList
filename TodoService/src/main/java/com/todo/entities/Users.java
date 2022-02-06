package com.todo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo.exceptions.AbstractErrorResponse;

@Entity
@Table(name = "users")
public class Users extends AbstractErrorResponse {

	@Id
	@GeneratedValue
	private Long id;
	private String userId;
	private String userName;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userId=" + userId + ", userName=" + userName + "]";
	}

}
