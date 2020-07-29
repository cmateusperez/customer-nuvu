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

import cc.nuvu.customer.domain.CreditCardDto;
import cc.nuvu.customer.domain.CustomerDto1;
import cc.nuvu.customer.domain.Response;
import cc.nuvu.customer.service.ICreditCardService;
import cc.nuvu.customer.service.impl.CustomerService;

@RestController
@RequestMapping("credit-card")
@CrossOrigin
public class CardCreditController {

	@Autowired
	CustomerService customerService;
	@Autowired
	private ICreditCardService creditCardService;

	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<Response<CustomerDto1>> add(@RequestBody CustomerDto1 customerDetail) {
		CustomerDto1 customerDTO = customerService.add(customerDetail);
		Response<CustomerDto1> response = buildResponse(customerDTO);
		return ResponseEntity.ok().body(response);
	}

	@ResponseBody
	@GetMapping("/getAll")
	public ResponseEntity<Response<List<CreditCardDto>>> getAll() {
		Response<List<CreditCardDto>> response = buildResponse(creditCardService.getAll());
		return ResponseEntity.ok().body(response);
	}

	@ResponseBody
	@PutMapping("/update")
	public ResponseEntity<Response<CustomerDto1>> update(@RequestParam(value = "id") Integer id,
			@RequestBody CustomerDto1 customerDetail) {
		CustomerDto1 customerDTO = customerService.update(id, customerDetail);
		Response<CustomerDto1> response = buildResponse(customerDTO);
		return ResponseEntity.ok().body(response);
	}

}
