/**
 * 
 */
package com.aloha.projectmgr.exception;


/**
 * @author Rahul
 *
 */
public enum ErrorCode {

	DATA_BINDING(1001,"Data binding error"),
	
	JSON_FORMAT(1002,"Wrong Json format"),
	
	DAO_EXCEPTION(2003,"Internal server error. Please try later.");
    
	private int errorCode;
	private String message;
	
    private ErrorCode(int errorCode,String message) {
            this.errorCode = errorCode;
            this.message=message;
    }
    
    public int errorCode() { return this.errorCode;}
    public String message() { return this.message;}
}
