package cc.nuvu.customer.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import cc.nuvu.customer.repository.entity.CreditCard;
import cc.nuvu.customer.service.domain.CreditCardDto;

@Mapper
public interface CreditCardMapper {

	CreditCard creditCardDtoToCreditCard(CreditCardDto creditCardDto);
	
	CreditCardDto creditCardToCreditCardDto(CreditCard creditCard);
	
	List<CreditCardDto> creditCardToCreditCardDto(List<CreditCard> creditCards);
}
