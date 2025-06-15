package com.org.CommercialService.Controller;

import com.org.CommercialService.DTO.Request.PaymentRequestDTO;
import com.org.CommercialService.DTO.Response.PaymentResponseDTO;
import com.org.CommercialService.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payAdvance")
    public ResponseEntity<?> payAdvanceForProperty(@RequestBody PaymentRequestDTO paymentRequestDTO){
        PaymentResponseDTO paymentResponseDTO = paymentService.payAdvance(paymentRequestDTO);
        return ResponseEntity.ok(paymentResponseDTO);
    }
}
