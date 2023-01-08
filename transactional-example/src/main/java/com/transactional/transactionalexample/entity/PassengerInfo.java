package com.transactional.transactionalexample.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Passenger_Info")
public class PassengerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long passengerId;
    private String name;
    private String email;
    private String source;
    private String Destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private double fare;


}
