package demo.imunoz.infrastructure.controller;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import demo.imunoz.domain.exception.DateFormatException;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;
import demo.imunoz.infrastructure.controller.productPrice.ProductPriceController;

@ControllerAdvice(assignableTypes = { ProductPriceController.class })
public class ExceptionHelper extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, Collections.singleton(ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { DomainException.class })
	public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
		return handleExceptionInternal(ex, Collections.singleton(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { DateFormatException.class })
	public ResponseEntity<Object> handleDateFormatException(DateFormatException ex, WebRequest request) {
		return handleExceptionInternal(ex, Collections.singleton(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
