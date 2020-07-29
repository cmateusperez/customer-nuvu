package cc.nuvu.customer.controller.impl;

import static cc.nuvu.customer.util.Utility.buildResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.controller.ICustomerContoller;
import cc.nuvu.customer.service.domain.CustomerDto1;
import cc.nuvu.customer.service.domain.Response;
import cc.nuvu.customer.service.impl.CustomerService;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController implements ICustomerContoller{

	@Autowired
	CustomerService customerService;

	@ResponseBody
	@PostMapping("/add")
	@Override
	public ResponseEntity<Response<CustomerDto1>> add(@RequestBody CustomerDto1 customerDetail) {
		CustomerDto1 customerDTO = customerService.add(customerDetail);
		Response<CustomerDto1> response = buildResponse(customerDTO);
		return ResponseEntity.ok().body(response);
	}

	@ResponseBody
	@GetMapping("/getAll")
	@Override
	public ResponseEntity<Response<List<CustomerDto1>>> getAll() {
		List<CustomerDto1> customersDTO = customerService.getAll();
		Response<List<CustomerDto1>> response = buildResponse(customersDTO);
		return ResponseEntity.ok().body(response);
	}

	@ResponseBody
	@PutMapping("/update")
	@Override
	public ResponseEntity<Response<CustomerDto1>> update(@RequestParam(value = "id") Integer id,
			@RequestBody CustomerDto1 customerDetail) {
		CustomerDto1 customerDTO = customerService.update(id, customerDetail);
		Response<CustomerDto1> response = buildResponse(customerDTO);
		return ResponseEntity.ok().body(response);
	}

}
