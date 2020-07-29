package cc.nuvu.customer.controller.impl;

import static cc.nuvu.customer.util.Utility.buildResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.domain.Response;
import cc.nuvu.customer.domain.TransactionDto;
import cc.nuvu.customer.service.IOperationManagerService;
import lombok.Data;

@RestController
@RequestMapping("transaction")
@Data
public class TransactionController {
	
	@Autowired
	IOperationManagerService iTransactionManagerService;
	
	@GetMapping("/report")
	public Response<List<TransactionDto>> report() {
		buildResponse(iTransactionManagerService.report());
		return buildResponse(iTransactionManagerService.report());
	}
	
	

}
