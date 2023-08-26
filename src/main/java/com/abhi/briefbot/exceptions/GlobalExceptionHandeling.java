package com.abhi.briefbot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abhi.briefbot.response.fail.ExceptionMessage;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;


/**
 * GlobalExceptionHandler class is responsible for handling exceptions that occur
 * throughout the project. It provides centralized exception handling to improve
 * error reporting, logging, and user experience.
 * 
 * This class follows the Singleton pattern to ensure a single instance handles
 * all exceptions globally.
 * 
 * Usage:
 *  - Initialize the GlobalExceptionHandler at the start of the application to
 *    set up global exception handling.
 *  - The exception handling behavior can be customized by implementing the
 *    ExceptionHandler interface and registering it with the GlobalExceptionHandler.
 * 
 * 
 * 
 * @author Abhishek jadon
 * @Date 22-Aug-2023
 * @Time 6:53:08 pm
 * @Year 2023
 * 
 * @see TextNotFoundException
 * @see ServerTimeOutException
 * @see ExceptionMessage
 * @see ExceptionHandler
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandeling {

	@ExceptionHandler(TextNotFoundException.class)
	public ResponseEntity<ExceptionMessage> textNotFoundException(TextNotFoundException ex) {
		String message = ex.getMessage();
		ExceptionMessage exceptionMessage = new ExceptionMessage(false, message);
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServerTimeOutException.class)
	public ResponseEntity<ExceptionMessage> serverTimeOutException(ServerTimeOutException ex) {
		String message = ex.getMessage();
		ExceptionMessage exceptionMessage = new ExceptionMessage(false, message);
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.REQUEST_TIMEOUT);
	}
	
	@ExceptionHandler(FailingHttpStatusCodeException.class)
	public ResponseEntity<ExceptionMessage> failingHttpStatusCodeException(FailingHttpStatusCodeException ex){
		String  str = ex.getMessage();
		ExceptionMessage exceptionMessage = new ExceptionMessage(false, str);
		return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.OK);
	}

}
