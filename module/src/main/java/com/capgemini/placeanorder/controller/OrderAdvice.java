package com.capgemini.placeanorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.placeanorder.exception.ErrorInfo;
import com.capgemini.placeanorder.exception.OrderException;
@RestControllerAdvice
public class OrderAdvice {

	@ExceptionHandler(value= {OrderException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
