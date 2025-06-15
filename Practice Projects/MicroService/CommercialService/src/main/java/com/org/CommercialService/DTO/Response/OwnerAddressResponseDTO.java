package com.org.CommercialService.DTO.Response;

import lombok.Data;

@Data
public class OwnerAddressResponseDTO {

    private String addressType;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
}
