package com.capg.exception;

public class BookingAlreadyCancelledException extends RuntimeException  {
	String msg;

	public BookingAlreadyCancelledException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}