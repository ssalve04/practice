package com.transactional.transactionalexample.repository;

import com.transactional.transactionalexample.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
