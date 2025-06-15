package com.org.CommercialService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private int paymentId;
    private String paymentType; // Advance, FullPayment
    private String paymentStatus;
    private String transactionId;
    private Long propertyId;
    private double amount;

}
