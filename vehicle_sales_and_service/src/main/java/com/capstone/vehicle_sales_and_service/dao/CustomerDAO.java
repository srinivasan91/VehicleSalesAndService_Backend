package com.capstone.vehicle_sales_and_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.vehicle_sales_and_service.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

	Customer findByEmail(String username);

}
