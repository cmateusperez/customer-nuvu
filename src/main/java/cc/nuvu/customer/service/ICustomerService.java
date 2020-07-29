package cc.nuvu.customer.service;

import java.util.List;

import cc.nuvu.customer.service.domain.CustomerDto1;

public interface ICustomerService {

	CustomerDto1 add(CustomerDto1 customerDTO);

	List<CustomerDto1> getAll();

	CustomerDto1 update(Integer id, CustomerDto1 customerDTO);

}
