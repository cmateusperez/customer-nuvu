package cc.nuvu.customer.domain;

import java.time.LocalDateTime;

import cc.nuvu.customer.repository.entity.CreditCardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

	private CreditCardStatus status;

	private String cardNumber;

	private Integer secretNumber;

	private LocalDateTime expirationDate;
	

}
