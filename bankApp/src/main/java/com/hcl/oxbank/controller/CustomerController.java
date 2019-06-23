package com.hcl.oxbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.oxbank.beans.CustomerBean;
import com.hcl.oxbank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<String> creatAccount(@RequestBody CustomerBean customerBean){
		String successMessage = customerService.addCustomer(customerBean); 
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

}
