package com.capg.exception;

public class MovieAlreadyExistsException extends RuntimeException {
	String msg;

	public MovieAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}