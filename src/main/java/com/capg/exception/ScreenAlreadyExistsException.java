package com.capg.exception;

public class ScreenAlreadyExistsException extends RuntimeException{

	String msg;

	public ScreenAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
