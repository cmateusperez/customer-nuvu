package cc.nuvu.customer.service;

import java.util.List;

import cc.nuvu.customer.service.domain.CreditCardDto;

public interface ICreditCardService {

	CreditCardDto add(CreditCardDto creditCardDto);

	List<CreditCardDto> getAll();

}
