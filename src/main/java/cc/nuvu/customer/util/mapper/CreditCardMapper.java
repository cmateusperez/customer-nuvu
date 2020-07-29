package cc.nuvu.customer.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import cc.nuvu.customer.domain.CreditCardDto;
import cc.nuvu.customer.repository.entity.CreditCard;

@Mapper
public interface CreditCardMapper {

	CreditCard creditCardDtoToCreditCard(CreditCardDto creditCardDto);
	
	CreditCardDto creditCardToCreditCardDto(CreditCard creditCard);
	
	List<CreditCardDto> creditCardToCreditCardDto(List<CreditCard> creditCards);
}
