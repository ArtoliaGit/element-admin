package com.artolia.admin.exception;

import org.springframework.http.HttpStatus;

public class CustomExcetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4867253202297140998L;

	private final String message;
	private final HttpStatus httpStatus;
	
	public CustomExcetion(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
