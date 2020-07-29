package cc.nuvu.customer.service;

import java.util.List;

import cc.nuvu.customer.service.domain.TransactionDto;

public interface IOperationManagerService {

	List<TransactionDto> report();

	TransactionDto deposit(String cardNumber, Double amount);

	TransactionDto withdraw(String cardNumber, Double amount);


}
