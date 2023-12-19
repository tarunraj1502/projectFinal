package com.capg.exception;

public class SeatNotAvailableException extends RuntimeException{

	String msg;

	public SeatNotAvailableException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

