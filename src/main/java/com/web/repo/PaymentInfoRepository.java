package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}