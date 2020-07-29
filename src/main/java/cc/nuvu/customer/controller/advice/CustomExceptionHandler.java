package cc.nuvu.customer.controller.advice;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import cc.nuvu.customer.service.domain.Response;
import cc.nuvu.customer.util.Constants;
import cc.nuvu.customer.util.exception.ResourceNotFoundException;
import cc.nuvu.customer.util.exception.UnexpectedException;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response<?>> handleResourceNotFoundException(ResourceNotFoundException ex) throws Exception {
		Object[] exceptionValues = { ex.getResourceName(), ex.getFieldName(), ex.getFieldValue() };
		String errorMessage = messageSource.getMessage(Constants.RESOURCE_NOT_FOUND, exceptionValues,
				Locale.getDefault());
		Response<String> response = buildErrorResponse(errorMessage, HttpStatus.NOT_FOUND);
		log.error(response);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(UnexpectedException.class)
	public ResponseEntity<Response<?>> handleUnexpectedException(UnexpectedException ex) throws Exception {
		Object[] exceptionValues = ex.getArgs();
		String errorMessage = messageSource.getMessage(ex.getMessage(), exceptionValues, Locale.getDefault());
		Response<String> response = buildErrorResponse(errorMessage, HttpStatus.PARTIAL_CONTENT);
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotSupportedException.class,
			HttpMediaTypeNotAcceptableException.class, MissingPathVariableException.class,
			ServletRequestBindingException.class, ConversionNotSupportedException.class, TypeMismatchException.class,
			HttpMessageNotReadableException.class, HttpMessageNotWritableException.class,
			MissingServletRequestPartException.class, BindException.class, NoHandlerFoundException.class,
			AsyncRequestTimeoutException.class })
	public ResponseEntity<Response<?>>  handleNotSupportedException(Exception ex) throws Exception {
		String errorMessage = messageSource.getMessage(Constants.BAD_REQUEST, null, Locale.getDefault());
		Response<String> response = buildErrorResponse(errorMessage, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	private static Response<String> buildErrorResponse(String messageError, HttpStatus httpStatus) {
		return new Response<String>(httpStatus.value(), httpStatus.getReasonPhrase(), LocalDateTime.now(),
				messageError);
	}

}
