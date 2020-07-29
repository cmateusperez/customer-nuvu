package cc.nuvu.customer.controller.impl;

import static cc.nuvu.customer.util.Utility.buildResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.controller.ITransationController;
import cc.nuvu.customer.service.IOperationManagerService;
import cc.nuvu.customer.service.domain.Response;
import cc.nuvu.customer.service.domain.TransactionDto;
import lombok.Data;

@RestController
@RequestMapping("transaction")
@Data
public class TransactionController implements ITransationController {

	@Autowired
	IOperationManagerService iTransactionManagerService;

	@Override
	@ResponseBody
	@GetMapping("/report")
	public Response<List<TransactionDto>> report() {
		return buildResponse(iTransactionManagerService.report());
	}

}
