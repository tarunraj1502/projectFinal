package com.capg.exception;

public class CannotCancelException extends RuntimeException {
	String msg;

	public CannotCancelException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

