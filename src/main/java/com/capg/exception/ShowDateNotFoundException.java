package com.capg.exception;

public class ShowDateNotFoundException extends RuntimeException {
	String msg;

	public ShowDateNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}