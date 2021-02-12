package com.kakaopay.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kakaopay.api.common.KPConstants;
import com.kakaopay.api.common.Response;
import com.kakaopay.api.exceptions.GeneralException;

@ControllerAdvice
public class ExceptionAdviceController {


	@ExceptionHandler(GeneralException.class)
	public ResponseEntity kpExceptionHandler(GeneralException e) {
		return new ResponseEntity<Response>(new Response(e.getErrCode(), e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
	
	
}
