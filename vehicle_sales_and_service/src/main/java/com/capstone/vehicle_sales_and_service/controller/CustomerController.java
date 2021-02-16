package com.capstone.vehicle_sales_and_service.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capstone.vehicle_sales_and_service.model.Customer;
import com.capstone.vehicle_sales_and_service.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
		
		Customer createdCustomer = custService.addCustomer(customer);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdCustomer.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello world";
	}
	
	@PostMapping("/customers")
	public Customer addCustomers(@RequestBody Customer customer) {
		
		Customer createdCustomer = custService.addCustomer(customer);
		
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(createdCustomer.getId()).toUri();
		
		return createdCustomer;
	}

}
