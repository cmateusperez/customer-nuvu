package cc.nuvu.customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.domain.Response;
import cc.nuvu.customer.domain.TransactionDto;
import cc.nuvu.customer.service.IOperationManagerService;
import cc.nuvu.customer.util.Utility;
import lombok.Data;

@RestController
@RequestMapping("operation-manager")
@CrossOrigin
@Data
public class OperationManagerController {
	
	@Autowired
	private IOperationManagerService operationManagerService;
	
	@PostMapping("/deposit")
	public Response<TransactionDto> deposit(String cardNumber, Double amount) {
		return Utility.buildResponse(operationManagerService.deposit(cardNumber, amount));
	}
	
	@PostMapping("/withdraw")
	public Response<TransactionDto> withdraw(String cardNumber, Double amount) {
		return Utility.buildResponse(operationManagerService.withdraw(cardNumber, amount));
	}

}
