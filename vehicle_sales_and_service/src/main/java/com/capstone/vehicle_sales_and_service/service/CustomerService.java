package com.capstone.vehicle_sales_and_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.vehicle_sales_and_service.dao.CustomerDAO;
import com.capstone.vehicle_sales_and_service.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer addCustomer(Customer customer) {
		return customerDAO.save(customer);
	}

}
