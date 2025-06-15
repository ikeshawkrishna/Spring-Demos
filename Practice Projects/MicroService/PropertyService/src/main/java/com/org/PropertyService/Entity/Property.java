package com.org.PropertyService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Entity
@Table(name = "Property_Details")
@Data
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_seq")
    @SequenceGenerator(name = "property_seq", sequenceName = "property_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String title;
    private String description;
    private String type; // e.g., "Office", "Warehouse", "Retail"
    private String location;
    private Double price;
    private String status; // e.g., "Available", "Sold", "Rented"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Double advancePayment;

    private Long ownerId;

    public Property(String title, String description, String type, String location, Double price, String status, LocalDateTime createdAt, LocalDateTime updatedAt, Long ownerId, Double advancePayment) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.location = location;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ownerId = ownerId;
        this.advancePayment = advancePayment;
    }
}
