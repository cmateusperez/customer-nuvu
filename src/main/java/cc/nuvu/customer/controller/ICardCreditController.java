package cc.nuvu.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cc.nuvu.customer.service.domain.CreditCardDto;
import cc.nuvu.customer.service.domain.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ICardCreditController {

	@ApiOperation(value = "Create credit card")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<CreditCardDto>> add(CreditCardDto CreditCardDto);

	@ApiOperation(value = "Query credit cards types list")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<List<CreditCardDto>>> getAll();

}