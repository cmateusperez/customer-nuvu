package cc.nuvu.customer.controller;

import cc.nuvu.customer.service.domain.Response;
import cc.nuvu.customer.service.domain.TransactionDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IOperationManagerController {

	@ApiOperation(value = "Deposit credit card")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	Response<TransactionDto> deposit(String cardNumber, Double amount);

	@ApiOperation(value = "Credit card withdrawal")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	Response<TransactionDto> withdraw(String cardNumber, Double amount);

}