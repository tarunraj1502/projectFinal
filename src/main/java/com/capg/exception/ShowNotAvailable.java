package com.capg.exception;

public class ShowNotAvailable extends RuntimeException {
	String msg;

	public ShowNotAvailable(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}