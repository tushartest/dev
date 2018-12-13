package com.aloha.projectmgr.exception;

public class ExceptionErrorCode {

	private int errorCode;
	private String message;
	
    private ExceptionErrorCode(int errorCode,String message) {
            this.errorCode = errorCode;
            this.message=message;
    }
    
    public int errorCode() { return this.errorCode;}
    public String message() { return this.message;}
}
