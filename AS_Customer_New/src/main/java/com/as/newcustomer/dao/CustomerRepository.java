package com.as.newcustomer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.newcustomer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByCustomerId(Integer customerId); 
	public List<Customer> findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByEmail(String email);
	public List<Customer> findByContact(Long contact);
}