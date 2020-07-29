

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cc.nuvu.customer.repository.CreditCardRepository;
import cc.nuvu.customer.repository.CustomerRepository;
import cc.nuvu.customer.repository.TransactionRepository;
import cc.nuvu.customer.repository.UserRepository;
import cc.nuvu.customer.repository.entity.CreditCard;
import cc.nuvu.customer.repository.entity.CreditCardStatus;
import cc.nuvu.customer.repository.entity.Customer;
import cc.nuvu.customer.repository.entity.Transaction;
import cc.nuvu.customer.repository.entity.TransactionType;
import cc.nuvu.customer.repository.entity.User;

@Component
public class DBInitializer implements CommandLineRunner {

	@Autowired
	UserRepository UserRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CreditCardRepository creditCardRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {
		createUser();
		createCustomer();
		createCreditCard();
		createTransactions();
	}

	private void createTransactions() {
		IntStream.range(0, 10).forEach((index)
				->{createTransaction( index %2 == 0 ? 
						TransactionType.DEBIT : TransactionType.CREDIT, getRandomAmount());});
				   
		
	}

	private double getRandomAmount() {
		return Math.random() * ( 100 - 10 );
	}

	private void createTransaction(TransactionType transactionType, double amount) {
		Transaction transaction = Transaction.builder()
										   .amount(amount)
										   .date(LocalDateTime.now())
										   .type(transactionType)
										   .creditCard(creditCardRepository.findById(1).get())
										   .build();
		
		transactionRepository.save(transaction);
	}

	private void createCreditCard() {
		CreditCard creditCard = CreditCard.builder()
										  .cardNumber("123456")
										  .customer(customerRepository.findById(1).get())
										  .expirationDate(LocalDateTime.now().minusMonths(-1))
										  .secretNumber(8989)
										  .status(CreditCardStatus.ACTIVE)
										  .build();
		creditCardRepository.save(creditCard);
	}

	private void createCustomer() {
		Customer customer = Customer.builder()
									.dni("123456")
									.email("customer@nuvu.com")
									.firstname("Pepe")
									.lastname("Levú")
									.build();
		customerRepository.save(customer);
	}

	private void createUser() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("LWZYuvWBFO2yRhcTzP+/4Q==");
		UserRepository.save(user);
	}

}
