package cc.nuvu.customer.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credit_card")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	private CreditCardStatus status;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "secret_number")
	private Integer secretNumber;

	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	@ManyToOne()
	@JoinColumn(name = "credit_card_id")
	@JsonBackReference
	private Customer customer;
	

}
