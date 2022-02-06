package com.todo.exceptions;

import org.springframework.http.HttpStatus;

public class AbstractErrorResponse {

	private HttpStatus statusCode;
	private String description;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AbstractErrorResponse [errorCode=" + statusCode + ", errorDescription=" + description + "]";
	}

}
