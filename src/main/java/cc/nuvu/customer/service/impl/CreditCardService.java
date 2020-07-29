package cc.nuvu.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.customer.repository.CreditCardRepository;
import cc.nuvu.customer.repository.entity.CreditCard;
import cc.nuvu.customer.service.ICreditCardService;
import cc.nuvu.customer.service.domain.CreditCardDto;
import cc.nuvu.customer.util.mapper.CreditCardMapper;

@Service
public class CreditCardService implements ICreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private CreditCardMapper creditCardMapper;

	@Override
	public CreditCardDto add(CreditCardDto creditCardDetail) {
		CreditCard creditCard = creditCardMapper.creditCardDtoToCreditCard(creditCardDetail);
		CreditCard creditCardUpdated = creditCardRepository.save(creditCard);
		return creditCardMapper.creditCardToCreditCardDto(creditCardUpdated);
	}

	@Override
	public List<CreditCardDto> getAll() {
		return creditCardMapper.creditCardToCreditCardDto(creditCardRepository.findAll());
	}

}
