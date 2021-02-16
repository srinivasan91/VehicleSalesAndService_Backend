package com.capstone.vehicle_sales_and_service.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.vehicle_sales_and_service.dao.CustomerDAO;
import com.capstone.vehicle_sales_and_service.model.Customer;


@Service
public class CustomerUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private CustomerDAO custRepository;
	
	@Autowired
	private PasswordEncoder passwordEncder;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = custRepository.findByEmail(username);
		
		
	    String password = customer.getPassword();
	    String encodedPassword = passwordEncder.encode(password);
		return new User(customer.getEmail(), encodedPassword, new ArrayList<>());
	}


	
}
