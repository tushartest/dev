package com.aloha.projectmgr.exception.dto;

import org.springframework.http.HttpStatus;

import com.aloha.projectmgr.exception.ErrorCode;
import com.aloha.projectmgr.exception.ErrorInfo;
import com.aloha.projectmgr.exception.GenericRuntimeException;




public class ExceptionDto extends ErrorInfo{

	public ExceptionDto(HttpStatus httpStatus, ErrorCode errorCode) {
		super(httpStatus, errorCode);		
	}

	public ExceptionDto(GenericRuntimeException exception) {
		super();
		this.setHttpStatus(500);
		this.setErrorCode(exception.getErrorCode());
		this.setMessage(exception.getErrorMesssage());
	}

}