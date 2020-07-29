package cc.nuvu.customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.controller.IOperationManagerController;
import cc.nuvu.customer.service.IOperationManagerService;
import cc.nuvu.customer.service.domain.Response;
import cc.nuvu.customer.service.domain.TransactionDto;
import cc.nuvu.customer.util.Utility;
import lombok.Data;

@RestController
@RequestMapping("operation-manager")
@CrossOrigin
@Data
public class OperationManagerController implements IOperationManagerController {
	
	@Autowired
	private IOperationManagerService operationManagerService;
	
	@Override
	@ResponseBody
	@PostMapping("/deposit")
	public Response<TransactionDto> deposit(String cardNumber, Double amount) {
		return Utility.buildResponse(operationManagerService.deposit(cardNumber, amount));
	}
	
	@Override
	@ResponseBody
	@PostMapping("/withdraw")
	public Response<TransactionDto> withdraw(String cardNumber, Double amount) {
		return Utility.buildResponse(operationManagerService.withdraw(cardNumber, amount));
	}

}
