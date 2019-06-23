package com.hcl.oxbank.customExc;

public class CustomException extends RuntimeException {

	public CustomException() {
		
	}
	
	public CustomException(String message) {
		super(message);
	}
}
