package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.PassengerInfo;
import com.web.entity.PaymentInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
