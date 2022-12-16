package com.as.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.as.booking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	public List<Booking> findByBookingId(Integer bookingId);
	public List<Booking> findByBookingDate(String bookingDate);
	public List<Booking> findByBookingTimeAndBookingDate(String bookingTime, String bookingDate);	
}
