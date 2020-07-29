package cc.nuvu.customer.service.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cc.nuvu.customer.repository.entity.CreditCardStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

	@ApiModelProperty(value = "Credit card status")
	@JsonInclude(Include.NON_NULL)
	private CreditCardStatus status;

	@ApiModelProperty(value = "Credit card card number")
	@JsonInclude(Include.NON_NULL)
	private String cardNumber;

	@ApiModelProperty(value = "Credit card secret number")
	@JsonInclude(Include.NON_NULL)
	private Integer secretNumber;

	@ApiModelProperty(value = "Credit card expiration date")
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime expirationDate;
	

}
