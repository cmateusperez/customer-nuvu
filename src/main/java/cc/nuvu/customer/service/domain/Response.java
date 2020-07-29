package cc.nuvu.customer.service.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cc.nuvu.customer.util.Constants;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response<T> {

	@JsonProperty("statusCode")
	@JsonInclude(Include.NON_NULL)
	private int statusCode;

	@JsonProperty("statusDescription")
	@JsonInclude(Include.NON_NULL)
	private String statusDescription;
	
	@JsonProperty("date")
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = Constants.DATE_FORMAT)
	private LocalDateTime localDate;

	@JsonProperty("payload")
	@JsonInclude(Include.NON_NULL)
	private T payload;
	


}