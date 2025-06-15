package com.org.PaymentService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payment_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private int paymentId;
    private String paymentType;
    private String paymentStatus;
    private String transactionId;
    private Long propertyId;
    private double amount;
}