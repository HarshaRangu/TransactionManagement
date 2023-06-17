package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.web.dto.FlightBookingAcknowledgement;
import com.web.dto.FlightBookingRequest;
import com.web.entity.PassengerInfo;
import com.web.entity.PaymentInfo;
import com.web.repo.PassengerInfoRepository;
import com.web.repo.PaymentInfoRepository;
import com.web.utils.PaymentUtils;

import java.util.UUID;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Transactional // (readOnly = false,isolation = Isolation.READ_COMMITTED,propagation =
					// Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);

		PaymentInfo paymentInfo = request.getPaymentInfo();

		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);

	}
}
