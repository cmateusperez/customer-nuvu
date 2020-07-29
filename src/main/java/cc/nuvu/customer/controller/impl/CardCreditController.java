package cc.nuvu.customer.controller.impl;

import static cc.nuvu.customer.util.Utility.buildResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.controller.ICardCreditController;
import cc.nuvu.customer.service.ICreditCardService;
import cc.nuvu.customer.service.domain.CreditCardDto;
import cc.nuvu.customer.service.domain.Response;

@RestController
@RequestMapping("credit-card")
@CrossOrigin
public class CardCreditController implements ICardCreditController {

	@Autowired
	private ICreditCardService creditCardService;

	@Override
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<Response<CreditCardDto>> add(@RequestBody CreditCardDto creditCardDetail) {
		CreditCardDto creditCardDto = creditCardService.add(creditCardDetail);
		Response<CreditCardDto> response = buildResponse(creditCardDto);
		return ResponseEntity.ok().body(response);
	}

	@Override
	@ResponseBody
	@GetMapping("/getAll")
	public ResponseEntity<Response<List<CreditCardDto>>> getAll() {
		Response<List<CreditCardDto>> response = buildResponse(creditCardService.getAll());
		return ResponseEntity.ok().body(response);
	}

}
