package cc.nuvu.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cc.nuvu.customer.service.domain.CustomerDto1;
import cc.nuvu.customer.service.domain.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ICustomerContoller {

	@ApiOperation(value = "Query customers types list")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<List<CustomerDto1>>> getAll();

	@ApiOperation(value = "Create customer")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<CustomerDto1>> add(CustomerDto1 customerDetail);

	@ApiOperation(value = "Update customer")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<CustomerDto1>> update(Integer id, CustomerDto1 customerDetail);

}
