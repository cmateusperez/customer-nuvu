package cc.nuvu.customer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.customer.domain.TransactionDto;
import cc.nuvu.customer.repository.CreditCardRepository;
import cc.nuvu.customer.repository.TransactionRepository;
import cc.nuvu.customer.repository.entity.CreditCard;
import cc.nuvu.customer.repository.entity.Transaction;
import cc.nuvu.customer.repository.entity.TransactionType;
import cc.nuvu.customer.service.IOperationManagerService;
import cc.nuvu.customer.util.mapper.TransactionMapper;

@Service
public class OperationManagerService implements IOperationManagerService {

	@Autowired
	private TransactionMapper transactionMapper;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CreditCardRepository creditCardRepository;

	@Override
	public List<TransactionDto> report() {
		return transactionMapper.transactionTotransactionDTO(transactionRepository.findAll());
	}

	@Override
	public TransactionDto deposit(String cardNumber, Double amount) {
		verify(cardNumber, amount);
		Transaction transaction = save(TransactionType.CREDIT, amount, loadCreditCardInfo(cardNumber));
		return transactionMapper.transactionTotransactionDTO(transaction);
	}

	@Override
	public TransactionDto withdraw(String cardNumber, Double amount) {
		verify(cardNumber, amount);
		Transaction transaction = save(TransactionType.DEBIT, amount, loadCreditCardInfo(cardNumber));
		return transactionMapper.transactionTotransactionDTO(transaction);
	}
	
	private Transaction save(TransactionType transactionType, Double amount, CreditCard creditCard) {
		return transactionRepository
				.save(createTransaction(transactionType, creditCard, amount));
	}

	private CreditCard loadCreditCardInfo(String cardNumber) {
		return creditCardRepository.findBycardNumber(cardNumber).orElseThrow();
	}

	private void verify(String cardNumber, Double amount) {
		Optional.ofNullable(cardNumber).orElseThrow();
		Optional.ofNullable(amount).orElseThrow();
	}
	
	private Transaction createTransaction(TransactionType transactionType, CreditCard creditCard, double amount) {
		return Transaction.builder().amount(amount).date(LocalDateTime.now()).type(transactionType)
				.creditCard(creditCard).build();

	}

}
