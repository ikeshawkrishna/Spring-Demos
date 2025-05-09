package com.example.FlightService.dto;

import com.example.FlightService.Entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAcknowledgement {
    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
