package com.as.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	private Integer bookingId;
	
	// Payment properties
	@Id
	private Integer paymentId;
	private Double amount;
	private String modeOfPayment;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payment(Integer bookingId, Integer paymentId, Double amount, String modeOfPayment) {
		super();
		this.bookingId = bookingId;
		this.paymentId = paymentId;
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", modeOfPayment=" + modeOfPayment + "]";
	}
	
}
