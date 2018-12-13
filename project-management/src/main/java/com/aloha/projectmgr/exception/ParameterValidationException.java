package com.aloha.projectmgr.exception;

import org.springframework.validation.BindingResult;

/**
 * @author Rahul
 *
 */
public class ParameterValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229758514074626035L;
	private BindingResult bindingResult;

	public ParameterValidationException() {		
	}

	public ParameterValidationException(BindingResult bindingResult) {		
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

}
