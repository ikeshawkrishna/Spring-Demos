package com.org.CommercialService.DTO;

import lombok.Data;

@Data
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private String type; // e.g., "Office", "Warehouse", "Retail"
    private String location;
    private Double price;
    private String status;
    private Double advancePayment;
    private Long ownerId;
}
