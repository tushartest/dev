package com.aloha.projectmgr.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Rahul
 *
 */
public class ErrorInfo {
	private int httpStatus;
	private int errorCode;
	private String message;
	/**
	 * 
	 */
	private List<FieldError> errors=new ArrayList<FieldError>();
	
	public ErrorInfo() {
		super();
	}
	
	public ErrorInfo(HttpStatus httpStatus, ErrorCode errorCode) {
		super();
		this.httpStatus = httpStatus.value();
		this.errorCode = errorCode.errorCode();
		this.message = errorCode.message();		
	}    
    
    public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

	public void addError(FieldError error) {
		errors.add(error);
	}
}