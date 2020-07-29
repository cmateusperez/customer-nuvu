package cc.nuvu.customer.domain;

import java.time.LocalDateTime;

import cc.nuvu.customer.repository.entity.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
	
	private LocalDateTime date;
	private Double amount;
	private TransactionType type;
	private String cardNumber;
	private String dni;
	private String firstname;
	private String lastname;


}
