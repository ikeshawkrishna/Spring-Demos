package com.example.FlightService.Util;

import com.example.FlightService.Exception.InsufficientFundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentUtil {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1",12000.00);
        paymentMap.put("acc2",10000.00);
        paymentMap.put("acc3",5000.00);
        paymentMap.put("acc4",8000.00);
    }

    public boolean validateCreditLimit(String accno, double amount){
        if(paymentMap.getOrDefault(accno,0.0) < amount){
            throw new InsufficientFundException("Insufficient fund......");
        }
        return true;
    }
}
