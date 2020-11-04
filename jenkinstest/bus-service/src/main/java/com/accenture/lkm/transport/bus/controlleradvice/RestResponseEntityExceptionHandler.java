package com.accenture.lkm.transport.bus.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
	public class RestResponseEntityExceptionHandler {
	    @ExceptionHandler(value = {Exception.class})
	    protected ResponseEntity<Object> handleConstraintViolation(Exception e) {
	        return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
	    }
}

