package com.example.FlightService.Controller;

import com.example.FlightService.Exception.ErrorResponse;
import com.example.FlightService.Exception.InsufficientFundException;
import com.example.FlightService.Service.FlightBookingService;
import com.example.FlightService.dto.FlightBookingAcknowledgement;
import com.example.FlightService.dto.FlightBookingRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class FlightController {
    @Autowired
    FlightBookingService flightBookingService;

    @PostMapping("/bookFlightTicket")
    public ResponseEntity<?> bookFlightTicket(@RequestBody @Valid FlightBookingRequest request){
        FlightBookingAcknowledgement flightBookingAcknowledgement = null;
        try{
            flightBookingAcknowledgement = flightBookingService.bookFlightTicket(request);
        } catch (InsufficientFundException e){
            return new ResponseEntity<ErrorResponse>(
                    new ErrorResponse("101",e.getMessage(),"Please add amount"), HttpStatus.BAD_REQUEST
            );
        }
        return ResponseEntity.ok(flightBookingAcknowledgement);
    }


}
