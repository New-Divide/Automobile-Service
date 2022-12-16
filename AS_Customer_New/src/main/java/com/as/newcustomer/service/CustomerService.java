package com.as.newcustomer.service;

import java.util.List;

import com.as.newcustomer.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerByCustomerId(Integer customerId); 
	public List<Customer> getCustomerByFirstName(String firstName);
	public List<Customer> getCustomerByLastName(String lastName);
	public List<Customer> getCustomerByEmail(String email);
	public List<Customer> getCustomerByContact(Long contact);
	public List<Customer> getCustomers();
}

