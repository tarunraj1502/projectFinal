package com.capg.exception;

public class NullValueException extends RuntimeException {
	
	String msg;

	public NullValueException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}