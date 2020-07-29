package cc.nuvu.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.customer.domain.CreditCardDto;
import cc.nuvu.customer.repository.CreditCardRepository;
import cc.nuvu.customer.repository.CustomerRepository;
import cc.nuvu.customer.repository.entity.CreditCard;
import cc.nuvu.customer.repository.entity.Customer;
import cc.nuvu.customer.service.ICreditCardService;
import cc.nuvu.customer.util.mapper.CreditCardMapper;
import lombok.Data;

@Service
@Data
public class CreditCardService implements ICreditCardService {
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CreditCardMapper creditCardMapper;

	@Override
	public CreditCardDto add(Integer idCustomer, CreditCardDto creditCardDto) {
		Customer customer = customerRepository.findById(idCustomer).orElseThrow(()-> new RuntimeException("Invalid Customer ID"));
		CreditCard creditCard = creditCardMapper.creditCardDtoToCreditCard(creditCardDto);
		creditCard.setCustomer(customer);
		creditCardRepository.save(creditCard);
		return creditCardDto;
	}

	@Override
	public List<CreditCardDto> getAll() {
		return creditCardMapper.creditCardToCreditCardDto(creditCardRepository.findAll());
	}


	public CreditCardDto update(CreditCardDto creditCardDto) {
		creditCardRepository.save(creditCardMapper.creditCardDtoToCreditCard(creditCardDto));
		return creditCardDto;
	}

}
