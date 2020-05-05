package com.anuj.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

//	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")

	@GetMapping(path="/basicauth")
	public AuthenticationBean AuthenticationBean() {
	//	throw new RuntimeException("Some Error Occured! Please Contact Support at ***-***");
	return new AuthenticationBean("You are authenticated");
	}
	

}
