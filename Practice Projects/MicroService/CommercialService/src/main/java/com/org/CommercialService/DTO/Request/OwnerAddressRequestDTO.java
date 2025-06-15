package com.org.CommercialService.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OwnerAddressRequestDTO {

    @NotBlank(message = "Addresstype is required")
    private String addressType;

    @NotBlank(message = "Address line 1 is required")
    private String addressLine1;
    private String addressLine2;

    @NotBlank(message = "city line 1 is required")
    private String city;

    @NotBlank(message = "state line 1 is required")
    private String state;

    @NotBlank(message = "country line 1 is required")
    private String country;

}
