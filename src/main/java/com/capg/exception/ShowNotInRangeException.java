package com.capg.exception;

public class ShowNotInRangeException extends RuntimeException{

	String msg;

	public ShowNotInRangeException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
