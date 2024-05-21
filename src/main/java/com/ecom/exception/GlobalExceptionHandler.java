package com.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.ecom.utils.CommonUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<?> noResourceFoundException(Exception e) {
		return CommonUtils.createBuildResponse("failed", e.getMessage() + " URL", HttpStatus.NOT_FOUND);
	}

}
