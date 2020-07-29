package cc.nuvu.customer.controller.advice;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cc.nuvu.customer.domain.Response;
import cc.nuvu.customer.util.Constants;
import cc.nuvu.customer.util.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response<?>> handleResourceNotFoundException(ResourceNotFoundException ex) throws Exception {
		Object[] exceptionValues = { ex.getResourceName(), ex.getFieldName(), ex.getFieldValue() };
		String errorMessage = messageSource.getMessage(Constants.RESOURCE_NOT_FOUND, exceptionValues, Locale.getDefault());
		Response<String> response = buildErrorResponse(errorMessage, HttpStatus.NOT_FOUND);
		log.error(response);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	private static Response<String> buildErrorResponse(String messageError, HttpStatus httpStatus) {
		return new Response<String>(httpStatus.value(), httpStatus.getReasonPhrase(), LocalDateTime.now(),
				messageError);
	}

}
