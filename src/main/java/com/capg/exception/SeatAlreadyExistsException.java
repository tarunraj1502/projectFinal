package com.capg.exception;

public class SeatAlreadyExistsException extends RuntimeException{
	String msg;

	public SeatAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}