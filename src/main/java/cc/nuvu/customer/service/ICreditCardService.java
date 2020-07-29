package cc.nuvu.customer.service;

import java.util.List;

import cc.nuvu.customer.domain.CreditCardDto;

public interface ICreditCardService {

	CreditCardDto add(Integer idCustomer, CreditCardDto creditCardDto);

	List<CreditCardDto> getAll();

	CreditCardDto update(CreditCardDto creditCardDto);


}
