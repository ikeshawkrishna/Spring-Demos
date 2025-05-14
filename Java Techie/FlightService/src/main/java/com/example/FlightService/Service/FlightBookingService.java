package com.example.FlightService.Service;

import com.example.FlightService.Entity.PassengerInfo;
import com.example.FlightService.Entity.PaymentInfo;
import com.example.FlightService.Repo.PassengerInfoRepo;
import com.example.FlightService.Repo.PaymentInfoRepo;
import com.example.FlightService.Util.PaymentUtil;
import com.example.FlightService.dto.FlightBookingAcknowledgement;
import com.example.FlightService.dto.FlightBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepo passengerInfoRepo;

    @Autowired
    private PaymentInfoRepo paymentInfoRepo;

    @Autowired
    private PaymentUtil paymentUtil;

    @Transactional(propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        FlightBookingAcknowledgement flightBookingAcknowledgement = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepo.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        paymentUtil.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfoRepo.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }

}
