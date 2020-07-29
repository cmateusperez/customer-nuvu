package cc.nuvu.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import cc.nuvu.customer.repository.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
	
	Optional<CreditCard> findBycardNumber(String cardNumber);
	
	

}
