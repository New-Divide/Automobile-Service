package com.as.booking.model;

import java.util.ArrayList;
import java.util.List;

import com.as.booking.entity.Booking;

public class BookingsResponse {
	
	private Booking booking;
	private Payment payment;
	private CustomerVSResponse customerVSResponse;
	
	public BookingsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingsResponse(Booking booking, CustomerVSResponse customerVSResponse, Payment payment) {
		super();
		this.booking = booking;
		this.customerVSResponse = customerVSResponse;
		this.payment = payment;
	}
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public CustomerVSResponse getCustomerVSResponse() {
		return customerVSResponse;
	}

	public void setCustomerVSResponse(CustomerVSResponse customerVSResponse) {
		this.customerVSResponse = customerVSResponse;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "BookingsResponse [booking=" + booking + ", payment=" + payment + ", customerVSResponse="
				+ customerVSResponse + "]";
	}

	public List<BookingsResponse> join(List<Booking> b, List<CustomerVSResponse> cvs, List<Payment> p){
		
		BookingsResponse bookingsResponse = new BookingsResponse();
		List<BookingsResponse> bookingsResponses = new ArrayList<>();
		
		for(Booking obj1 : b) {
			for (CustomerVSResponse obj2 : cvs) {
				for (Payment obj3 : p) {
					if(obj1.getCustomerId() == obj2.getCustomer().getCustomerId() && obj1.getBookingId() == obj3.getBookingId()) {
						bookingsResponse.setBooking(obj1);
						bookingsResponse.setCustomerVSResponse(obj2);
						bookingsResponse.setPayment(obj3);
						bookingsResponses.add(bookingsResponse);
					}
				}
			}
		}
		
		return bookingsResponses;
	}

}
