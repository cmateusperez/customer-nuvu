package cc.nuvu.customer.service.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto1 {

	@ApiModelProperty(value = "Customer id")
	@JsonInclude(Include.NON_NULL)
	private Integer id;

	@ApiModelProperty(value = "Customer dni")
	@JsonInclude(Include.NON_NULL)
	private String dni;

	@ApiModelProperty(value = "Customer firstname")
	@JsonInclude(Include.NON_NULL)
	private String firstname;

	@ApiModelProperty(value = "Customer lastname")
	@JsonInclude(Include.NON_NULL)
	private String lastname;

	@ApiModelProperty(value = "Customer email")
	@JsonInclude(Include.NON_NULL)
	private String email;

}
