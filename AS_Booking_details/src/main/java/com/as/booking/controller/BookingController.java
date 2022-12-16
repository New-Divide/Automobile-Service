package com.as.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.as.booking.entity.Booking;
import com.as.booking.model.BookingsResponse;
import com.as.booking.model.CustomerVSResponse;
import com.as.booking.model.Payment;
import com.as.booking.service.BookingServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String GET_ONE_BOOKING_URL="http://localhost:8082/vehiclesAndServices/getVSByBookingId/";
	private static final String GET_ALL_BOOKINGS_URL="http://localhost:8082/vehiclesAndServices/getVSs";
	private static final String GET_ALL_BOOKINGS_ON_A_PARTICULAR_DATE_URL="http://localhost:8082/vehiclesAndServices/getVSByBookingId/";
	private static final String GET_ALL_BOOKINGS_ON_A_PARTICULAR_TIME_AND_DATE_URL="http://localhost:8082/vehiclesAndServices/getVSByBookingId/";

	private static final String GET_ALL_BOOKINGS_UNDER_ONE_CUSTOMER_URL="http://localhost:8082/vehiclesAndServices/getVSByCustomerId/";
	
	private static final String GET_ALL_BOOKINGS_OF_A_PARTICULAR_VEHICLE_TYPE_URL="http://localhost:8082/vehiclesAndServices/getVSByVehicleType/";
	private static final String GET_ALL_BOOKINGS_OF_A_PARTICULAR_VEHICLE_MAKE_URL="http://localhost:8082/vehiclesAndServices/getVSByMakeOfVehicle/";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_OILFILTER_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_oilFilter/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_BRAKEPADS_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_brakePads/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_ENGINEOIL_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_engineOil/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_ACFILTER_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_acFilter/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_WASHING_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_washing/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_POLISHING_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_polishing/1";
	private static final String GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_BATTERY_SERVICE_URL="http://localhost:8082/vehiclesAndServices/getVSByFlag_batteryReplace/1";
	
	private static final String GET_ONE_PAYMENT_URL="http://localhost:8083/getPaymentByBookingId/";
	private static final String GET_ALL_PAYMENTS_URL="http://localhost:8083/getPayments";
	private static final String GET_ALL_PAYMENTS_FOR_A_PARTICULAR_MODE_OF_PAYMENT_URL="http://localhost:8083/getPaymentByModeOfPayment/";
	
	
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<List<BookingsResponse>> getBooking(@PathVariable Integer bookingId){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ONE_BOOKING_URL+bookingId,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ONE_PAYMENT_URL+bookingId,List.class);
		List<Booking> b = bookingServiceImpl.getBookingByBookingId(bookingId);
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<List<BookingsResponse>> getAllBookings(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOnAParticularDate/{date}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOnAParticularDate(@PathVariable String date){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_ON_A_PARTICULAR_DATE_URL+date,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookingByBookingDate(date);
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOnAParticularTimeAndDate/{time}/{date}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOnAParticularTimeAndDate(@PathVariable String time, @PathVariable String date){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_ON_A_PARTICULAR_TIME_AND_DATE_URL+time+"/"+date,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookingByBookingTimeAndBookingDate(time, date);
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsUnderOneCustomer/{customerId}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsUnderOneCustomer(@PathVariable Integer customerId){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_UNDER_ONE_CUSTOMER_URL+customerId,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfAParticularVehicleType/{vehicleType}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfAParticularVehicleType(@PathVariable String vehicleType){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_A_PARTICULAR_VEHICLE_TYPE_URL+vehicleType,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfAParticularVehicleMake/{makeOfVehicle}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfAParticularVehicleMake(@PathVariable String makeOfVehicle){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_A_PARTICULAR_VEHICLE_MAKE_URL+makeOfVehicle,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingOilFilterService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingOilFilterService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_OILFILTER_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingBrakePadsService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingBrakePadsService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_BRAKEPADS_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingEngineOilService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingEngineOilService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_ENGINEOIL_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingACFilterService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingACFilterService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_ACFILTER_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingWashingService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingWashingService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_WASHING_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingPolishingService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingPolishingService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_POLISHING_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsOfVehiclesHavingBatteryService")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsOfVehiclesHavingBatteryService(){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_OF_VEHICLES_HAVING_BATTERY_SERVICE_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
	@GetMapping("/getAllBookingsForAParticularModeOfPayment/{modeOfPayment}")
	public ResponseEntity<List<BookingsResponse>> getAllBookingsForAParticularModeOfPayment(@PathVariable String modeOfPayment){
		
		List<CustomerVSResponse> cvs = restTemplate.getForObject(GET_ALL_BOOKINGS_URL,List.class);
		List<Payment> p = restTemplate.getForObject(GET_ALL_PAYMENTS_FOR_A_PARTICULAR_MODE_OF_PAYMENT_URL,List.class);
		List<Booking> b = bookingServiceImpl.getBookings();
		BookingsResponse bookingsResponse = new BookingsResponse();
		return new ResponseEntity<List<BookingsResponse>> (bookingsResponse.join(b,cvs, p),HttpStatus.OK);
	}
	
}


































