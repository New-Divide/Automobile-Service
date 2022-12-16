package com.as.booking.service;

import java.util.List;

import com.as.booking.entity.Booking;

public interface BookingService {
	
	public List<Booking> getBookingByBookingId(Integer bookingId);
	public List<Booking> getBookingByBookingDate(String bookingDate);
	public List<Booking> getBookingByBookingTimeAndBookingDate(String bookingTime, String bookingDate);	
	public List<Booking> getBookings();
}
