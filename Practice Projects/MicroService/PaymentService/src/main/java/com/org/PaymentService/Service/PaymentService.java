package com.org.PaymentService.Service;

import com.org.PaymentService.Entity.Payment;
import com.org.PaymentService.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        System.out.println("Payment-Service Request : {}" + payment);

        return repository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int paymentId)  {
        Payment payment=repository.findByPaymentId(paymentId);
        System.out.println("paymentService findPaymentHistoryByOrderId >> " + payment);
        return payment ;
    }
}
