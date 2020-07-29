package cc.nuvu.customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.customer.controller.IUserController;
import cc.nuvu.customer.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController implements IUserController {
	
	@Autowired
	IUserService userService;

	@Override
	@ResponseBody
	@PostMapping("/login")
	public String login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		String token = userService.getJWTToken(username, pwd);
		return token;

	}


}
