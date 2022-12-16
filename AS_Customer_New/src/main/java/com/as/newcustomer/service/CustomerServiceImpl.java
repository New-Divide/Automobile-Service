package com.as.newcustomer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.newcustomer.dao.CustomerRepository;
import com.as.newcustomer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return customerRepository.findByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastName(lastName);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

	@Override
	public List<Customer> getCustomerByContact(Long contact) {
		// TODO Auto-generated method stub
		return customerRepository.findByContact(contact);
	}
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> getCustomerByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerId(customerId);
	}
	
}