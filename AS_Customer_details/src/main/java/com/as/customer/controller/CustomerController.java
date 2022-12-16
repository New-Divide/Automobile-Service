package com.as.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.customer.entity.Customer;
import com.as.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/getCustomerByCustomerId/{customerId}")
	public ResponseEntity<List<Customer>> getCustomerByCustomerId(@PathVariable Integer customerId){
		
		List<Customer> customer = customerServiceImpl.getCustomerByCustomerId(customerId);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByFirstName/{firstName}")
	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable String firstName){
		
		List<Customer> customer = customerServiceImpl.getCustomerByFirstName(firstName);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByLastName/{lastName}")
	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable String lastName){
		
		List<Customer> customer = customerServiceImpl.getCustomerByLastName(lastName);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByEmail/{email}")
	public ResponseEntity<List<Customer>> getCustomerByEmail(@PathVariable String email){
		
		List<Customer> customer = customerServiceImpl.getCustomerByEmail(email);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByContact/{contact}")
	public ResponseEntity<List<Customer>> getCustomerByContact(@PathVariable Long contact){
		
		List<Customer> customer = customerServiceImpl.getCustomerByContact(contact);
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers(){
		
		List<Customer> customers = customerServiceImpl.getCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
}
