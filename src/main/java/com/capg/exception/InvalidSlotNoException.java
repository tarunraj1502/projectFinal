package com.capg.exception;

public class InvalidSlotNoException extends RuntimeException{

	String msg;

	public InvalidSlotNoException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
