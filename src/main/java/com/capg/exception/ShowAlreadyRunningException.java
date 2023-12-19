package com.capg.exception;

public class ShowAlreadyRunningException extends RuntimeException {
	
	String msg;

	public ShowAlreadyRunningException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}