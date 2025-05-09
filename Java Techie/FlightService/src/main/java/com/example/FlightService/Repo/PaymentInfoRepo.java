package com.example.FlightService.Repo;

import com.example.FlightService.Entity.PassengerInfo;
import com.example.FlightService.Entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String> {

}
