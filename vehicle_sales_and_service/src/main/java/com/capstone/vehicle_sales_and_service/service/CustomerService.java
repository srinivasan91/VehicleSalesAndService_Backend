package com.capstone.vehicle_sales_and_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.vehicle_sales_and_service.dao.CustomerDAO;
import com.capstone.vehicle_sales_and_service.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer addCustomer(Customer customer) {
		emailService.sendMail(customer.getEmail(), "Succcess - Congrats..!" , "You are Added Successfully..!");
		return customerDAO.save(customer);
	}

}
