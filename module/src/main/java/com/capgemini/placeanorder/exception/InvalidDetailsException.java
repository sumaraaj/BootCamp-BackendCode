package com.capgemini.placeanorder.exception;

@SuppressWarnings("serial")
public class InvalidDetailsException extends Exception{
	public InvalidDetailsException(String error_Msg) {
		super(error_Msg);
	}
}
