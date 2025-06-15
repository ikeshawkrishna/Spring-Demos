package com.org.CommercialService.Service;

import com.org.CommercialService.DTO.Request.PaymentRequestDTO;
import com.org.CommercialService.DTO.Response.PaymentResponseDTO;
import com.org.CommercialService.Entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    public PaymentResponseDTO payAdvance(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment.setPropertyId(paymentRequestDTO.getPayment().getPropertyId());
        payment.setPaymentType(paymentRequestDTO.getPayment().getPaymentType());
        payment.setAmount(paymentRequestDTO.getPayment().getAmount());


        Payment paymentResponse = restTemplate.postForObject("http://localhost:8081/payment/doPayment", payment, Payment.class);
        System.out.println("paymentResponse >> " + paymentResponse);
        String Message = paymentResponse.getPaymentStatus().equals("success") ? "Payment Success" : "Payment failed";

        return new PaymentResponseDTO(paymentResponse.getAmount(), paymentResponse.getTransactionId(), Message);

    }

}
