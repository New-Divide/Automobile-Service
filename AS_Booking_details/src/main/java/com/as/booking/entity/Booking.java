package com.as.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	// Booking properties
	@Id
	private Integer bookingId;
	private Integer customerId;
	private String bookingDate;
	private String bookingTime;
	private String pickAndDropService;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookingId, Integer customerId, String bookingDate, String bookingTime, String pickAndDropService) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.pickAndDropService = pickAndDropService;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getPickAndDropService() {
		return pickAndDropService;
	}

	public void setPickAndDropService(String pickAndDropService) {
		this.pickAndDropService = pickAndDropService;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
				+ ", pickAndDropService=" + pickAndDropService + "]";
	}
	
}
