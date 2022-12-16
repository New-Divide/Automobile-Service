package com.as.payment.service;

import java.util.List;

import com.as.payment.entity.Payment;

public interface PaymentService {
	
	public void updatePayment(Integer bookingId);
	public List<Payment> getPaymentByBookingId(Integer bookingId);
	public List<Payment> getPaymentByAmount(Double amount);
	public List<Payment> getPaymentByModeOfPayment(String modeOfPayment);
	public List<Payment> getPayments();
}
