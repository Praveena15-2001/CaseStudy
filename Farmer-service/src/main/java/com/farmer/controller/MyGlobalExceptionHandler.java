package com.farmer.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.farmer.exception.FarmerNotFoundException;
import com.farmer.pojo.ErrorResponse;

@RestControllerAdvice
	public class MyGlobalExceptionHandler
	{

		
	//	@ExceptionHandler(value = {FarmerNotFoundException.class})
        public ErrorResponse FarmerNotFoundException(FarmerNotFoundException f) {
			
			ErrorResponse error=new ErrorResponse();
			error.setStatusmsg(HttpStatus.NOT_FOUND);
			error.setDatetime(LocalDateTime.now());
			error.setMsg(f.getMessage());
			return error;
			
		}
		
		@ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
		public ErrorResponse methodtNotSupport(HttpRequestMethodNotSupportedException f) {
			
			ErrorResponse error=new ErrorResponse();
			error.setStatusmsg(HttpStatus.METHOD_NOT_ALLOWED);
			error.setDatetime(LocalDateTime.now());
			error.setMsg(f.getMessage());
			return error;
			
		}
		
		
	//	@ExceptionHandler(value = {Exception.class})
		public ErrorResponse handleException(Exception f) {
			
			ErrorResponse error=new ErrorResponse();
			error.setStatusmsg(HttpStatus.BAD_REQUEST);
			error.setDatetime(LocalDateTime.now());
			error.setMsg(f.getMessage());
			return error;
			
		}
	}
