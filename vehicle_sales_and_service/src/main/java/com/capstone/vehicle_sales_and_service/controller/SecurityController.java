package com.capstone.vehicle_sales_and_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.vehicle_sales_and_service.json_web_token.JWTUtil;
import com.capstone.vehicle_sales_and_service.model.AuthRequest;

@RestController
@CrossOrigin
public class SecurityController {
	
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTUtil jetUtil;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		System.out.println("user Email : " + authRequest.getUseremail());
		System.out.println("user pwd : " + authRequest.getPassword());
		
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authRequest.getUseremail(), authRequest.getPassword()
							)
					);
		}catch(Exception e) {
			throw new Exception("invalid credientials");
		}
		
		System.out.println(jetUtil.generateToken(authRequest.getUseremail()));
		return jetUtil.generateToken(authRequest.getUseremail());
		
	}
}
