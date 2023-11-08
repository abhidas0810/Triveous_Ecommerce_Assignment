package com.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @param cartException : it handles all types of cartException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> clientExceptionHandler(CartException cartException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(cartException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param categoryException : it handles all types of categoryException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> clientExceptionHandler(CategoryException categoryException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(categoryException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param userException : it handles all types of userException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> clientExceptionHandler(UserException userException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(userException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param productException : it handles all types of productException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productExceptionHandler(
			ProductException productException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(productException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param orderException : it handles all types of orderException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> claimExceptionHandler(OrderException orderException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(orderException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param orderItemException : it handles all types of orderItemException which is checked exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(OrderItemException.class)
	public ResponseEntity<MyErrorDetails> claimExceptionHandler(OrderItemException orderItemException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(orderItemException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param methodArgumentNotValidException : it handles all types of methodArgumentNotValidException which is to be thrown when an invalid argument passed.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException methodArgumentNotValidException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param noHandlerFoundException : it handles all types of noHandlerFoundException which is to be thrown when dispatcherServlet can't find a handler for a request.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 404.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(
			NoHandlerFoundException noHandlerFoundException, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(noHandlerFoundException.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param exception : it handles all types of exception.
	 * @param req : general webRequest metadata.
	 * @return : responseEntity of customized error details with http status of error code 400.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception exception, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(exception.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

}
