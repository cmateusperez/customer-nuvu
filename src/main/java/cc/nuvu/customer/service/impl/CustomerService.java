package cc.nuvu.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.customer.repository.CustomerRepository;
import cc.nuvu.customer.repository.entity.Customer;
import cc.nuvu.customer.service.ICustomerService;
import cc.nuvu.customer.service.domain.CustomerDto1;
import cc.nuvu.customer.util.Constants;
import cc.nuvu.customer.util.Utility;
import cc.nuvu.customer.util.exception.ResourceNotFoundException;
import cc.nuvu.customer.util.mapper.CustomerMapper;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerDto1 add(CustomerDto1 customerDTO) {
		Customer customer = customerMapper.customerDTOtoCustomer(customerDTO);
		Customer customerSaved = customerRepository.save(customer);
		return customerMapper.customerToCustomerDTO(customerSaved);
	}

	@Override
	public List<CustomerDto1> getAll() {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.customerToCustomerDTO(customers);
	}

	@Override
	public CustomerDto1 update(Integer id, CustomerDto1 customerDTO) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.RESOURCE_NOT_FOUND, Constants.ID, id));
		Utility.copyPropertiesIgnoreNull(customerDTO, customer);
		Customer customerUpdate = customerRepository.save(customer);
		return customerMapper.customerToCustomerDTO(customerUpdate);
	}

}
