package com.transactional.transactionalexample.dto;

import com.transactional.transactionalexample.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingAcknowledgment {
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
