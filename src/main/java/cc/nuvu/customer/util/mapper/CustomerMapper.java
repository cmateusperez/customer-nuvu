package cc.nuvu.customer.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import cc.nuvu.customer.repository.entity.Customer;
import cc.nuvu.customer.service.domain.CustomerDto1;

@Mapper
public interface CustomerMapper {

	Customer customerDTOtoCustomer(CustomerDto1 customerDTO);
	
	CustomerDto1 customerToCustomerDTO(Customer customer);
	
	List<CustomerDto1> customerToCustomerDTO(List<Customer> customers);
}
