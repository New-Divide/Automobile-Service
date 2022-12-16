package com.as.payment;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.as.payment.model.VS;

@FeignClient(name="VehicleAndService-MS")
public interface VSConsumer {
	
	@GetMapping("/getVSByBookingIdForPayment/{bookingId}")
	public ResponseEntity<List<VS>> getVSByBookingIdForPayment(@PathVariable Integer bookingId);
	
}
