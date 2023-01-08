package com.transactional.transactionalexample.repository;

import com.transactional.transactionalexample.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
