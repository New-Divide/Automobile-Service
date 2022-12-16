package com.as.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.payment.entity.Payment;
import com.as.payment.service.PaymentServiceImpl;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@GetMapping("/getPaymentByBookingId/{bookingId}")
	public ResponseEntity<List<Payment>> getPaymentByBookingId(@PathVariable Integer bookingId){
		
		 paymentServiceImpl.updatePayment(bookingId);
		 List<Payment> payment = paymentServiceImpl.getPaymentByBookingId(bookingId);
		 return new ResponseEntity<List<Payment>>(payment,HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentByAmount/{amount}")
	public ResponseEntity<List<Payment>> getPaymentByAmount(@PathVariable Double amount){
		
		List<Payment> tempPayment = paymentServiceImpl.getPayments();
		for (Payment obj : tempPayment) {
			paymentServiceImpl.updatePayment(obj.getBookingId());
		}
		List<Payment> payment = paymentServiceImpl.getPaymentByAmount(amount);
		return new ResponseEntity<List<Payment>>(payment,HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentByModeOfPayment/{modeOfPayment}")
	public ResponseEntity<List<Payment>> getPaymentByModeOfPayment(@PathVariable String modeOfPayment){
		
		List<Payment> tempPayment = paymentServiceImpl.getPayments();
		for (Payment obj : tempPayment) {
			paymentServiceImpl.updatePayment(obj.getBookingId());
		}
		List<Payment> payment = paymentServiceImpl.getPaymentByModeOfPayment(modeOfPayment);
		return new ResponseEntity<List<Payment>>(payment,HttpStatus.OK);
	}
	
	@GetMapping("/getPayments")
	public ResponseEntity<List<Payment>> getPayments(){
		
		List<Payment> tempPayment = paymentServiceImpl.getPayments();
		for (Payment obj : tempPayment) {
			paymentServiceImpl.updatePayment(obj.getBookingId());
		}
		List<Payment> payments = paymentServiceImpl.getPayments();
		return new ResponseEntity<List<Payment>>(payments,HttpStatus.OK);
	}
	
}
