package cc.nuvu.customer.service.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cc.nuvu.customer.repository.entity.TransactionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
	
	@ApiModelProperty(value = "Transaction date")
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime date;
	
	@ApiModelProperty(value = "Transaction amount")
	@JsonInclude(Include.NON_NULL)
	private Double amount;
	
	@ApiModelProperty(value = "Transaction type")
	@JsonInclude(Include.NON_NULL)
	private TransactionType type;
	
	@ApiModelProperty(value = "Transaction cardNumber")
	@JsonInclude(Include.NON_NULL)
	private String cardNumber;
	
	@ApiModelProperty(value = "Transaction dni")
	@JsonInclude(Include.NON_NULL)
	private String dni;
	
	@ApiModelProperty(value = "Transaction firstname")
	@JsonInclude(Include.NON_NULL)
	private String firstname;
	
	@ApiModelProperty(value = "Transaction lastname")
	@JsonInclude(Include.NON_NULL)
	private String lastname;

}
