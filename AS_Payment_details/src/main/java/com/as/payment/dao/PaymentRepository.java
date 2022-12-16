package com.as.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.payment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	public List<Payment> findByBookingId(Integer bookingId);
	public List<Payment> findByAmount(Double amount);
	public List<Payment> findByModeOfPayment(String modeOfPayment);
}
