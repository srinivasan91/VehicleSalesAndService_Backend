package com.capstone.vehicle_sales_and_service.model;



public class AuthRequest {
	
	
	
	private String useremail;
	private String password;
	
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRequest(String useremail, String password) {
		super();
		this.useremail = useremail;
		this.password = password;
	}

	public String getUseremail() {
		return useremail;
	}

	public String getPassword() {
		return password;
	}
	
	

}
