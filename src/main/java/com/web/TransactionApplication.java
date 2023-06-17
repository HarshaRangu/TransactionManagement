package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.FlightBookingAcknowledgement;
import com.web.dto.FlightBookingRequest;
import com.web.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionApplication {

	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
