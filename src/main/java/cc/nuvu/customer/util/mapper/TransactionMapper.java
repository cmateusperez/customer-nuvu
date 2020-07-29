package cc.nuvu.customer.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cc.nuvu.customer.domain.TransactionDto;
import cc.nuvu.customer.repository.entity.Transaction;

@Mapper
public interface TransactionMapper {

	Transaction transactionDTOtoTransaction(TransactionDto transactionDto);
	
	@Mappings({ @Mapping(target = "dni", source = "creditCard.customer.dni"),
				@Mapping(target = "firstname", source = "creditCard.customer.firstname"),
				@Mapping(target = "lastname", source = "creditCard.customer.lastname"),
				@Mapping(target = "cardNumber", source = "creditCard.cardNumber")
	
	})
	TransactionDto transactionTotransactionDTO(Transaction transaction);

	List<TransactionDto> transactionTotransactionDTO(List<Transaction> transactionions);
}
