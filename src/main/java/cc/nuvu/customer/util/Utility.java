package cc.nuvu.customer.util;

import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;

import cc.nuvu.customer.service.domain.Response;

public class Utility {

	public static void copyPropertiesIgnoreNull(Object source, Object target) {
		String[] nullPropertyNames = getNullPropertyNames(source);
		BeanUtils.copyProperties(source, target, nullPropertyNames);
	}

	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
				.filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
	}

	public static <T> Response<T> buildResponse(T payload) {
		int statusCode;
		String statusDesc = null;
		if (payload == null) {
			statusCode = HttpStatus.NO_CONTENT.value();
			statusDesc = HttpStatus.NO_CONTENT.getReasonPhrase();
		} else {
			statusCode = HttpStatus.OK.value();
			statusDesc = HttpStatus.OK.getReasonPhrase();
		}
		return new Response<T>(statusCode, statusDesc, LocalDateTime.now(), payload);
	}

}
