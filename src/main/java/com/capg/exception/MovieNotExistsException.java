package com.capg.exception;

public class MovieNotExistsException extends RuntimeException{

	String msg;

	public MovieNotExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

