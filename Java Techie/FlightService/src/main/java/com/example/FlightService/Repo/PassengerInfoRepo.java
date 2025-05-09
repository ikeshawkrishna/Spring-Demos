package com.example.FlightService.Repo;

import com.example.FlightService.Entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {
}
