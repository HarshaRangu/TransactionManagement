package com.web.dto;

import com.web.entity.PassengerInfo;
import com.web.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;

	private PaymentInfo paymentInfo;
}
