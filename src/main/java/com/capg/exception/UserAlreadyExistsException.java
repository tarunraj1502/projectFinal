package com.capg.exception;

public class UserAlreadyExistsException extends RuntimeException{

	String msg;

   public UserAlreadyExistsException(String msg)
   {
	super();
	this.msg = msg;
    }

	public String getMsg() {
		return msg;
	}
}