package com.as.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.payment.VSConsumer;
import com.as.payment.dao.PaymentRepository;
import com.as.payment.entity.Payment;
import com.as.payment.model.Calculator;
import com.as.payment.model.VS;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private VSConsumer vsConsumer;
	
	@Override
	public void updatePayment(Integer bookingId) {
		// TODO Auto-generated method stub
		Calculator calculator = new Calculator();
		VS vs = vsConsumer.getVSByBookingIdForPayment(bookingId).getBody().get(0);
		Double updatedAmount = calculator.calculateAmount(vs);
		Payment updatedPayment = paymentRepository.findByBookingId(bookingId).get(0);
		if(updatedPayment.getAmount() != updatedAmount) {
			updatedPayment.setAmount(updatedAmount);
		}
		paymentRepository.save(updatedPayment);
	}

	@Override
	public List<Payment> getPaymentByBookingId(Integer bookingId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByBookingId(bookingId);
	}

	@Override
	public List<Payment> getPaymentByAmount(Double amount) {
		// TODO Auto-generated method stub
		return paymentRepository.findByAmount(amount);
	}

	@Override
	public List<Payment> getPaymentByModeOfPayment(String modeOfPayment) {
		// TODO Auto-generated method stub
		return paymentRepository.findByModeOfPayment(modeOfPayment);
	}

	@Override
	public List<Payment> getPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

}
