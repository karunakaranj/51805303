package com.hcl.oxbank.customExc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> notFoundException(CustomException errMsg) {
		ErrorResponse resposne = new ErrorResponse();
		resposne.setMessage(errMsg.getMessage());
		return new ResponseEntity<ErrorResponse>(resposne, HttpStatus.NOT_FOUND);
	}
	
}