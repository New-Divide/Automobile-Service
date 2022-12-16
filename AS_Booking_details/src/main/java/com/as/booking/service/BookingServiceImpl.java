package com.as.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.booking.dao.BookingRepository;
import com.as.booking.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> getBookingByBookingId(Integer bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingId(bookingId);
	}

	@Override
	public List<Booking> getBookingByBookingDate(String bookingDate) {
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingDate(bookingDate);
	}

	@Override
	public List<Booking> getBookingByBookingTimeAndBookingDate(String bookingTime, String bookingDate) {
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingTimeAndBookingDate(bookingTime, bookingDate);
	}

	@Override
	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

}
