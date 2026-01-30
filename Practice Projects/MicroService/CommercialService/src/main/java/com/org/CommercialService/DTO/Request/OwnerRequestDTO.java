package com.org.CommercialService.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Data
@Schema(
    description = "Owner registration request data",
    example = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"phone\": \"+1-555-1234\", \"ownerAddressDetails\": []}"
)
public class OwnerRequestDTO {

    @NotBlank(message = "Name is required")
    @Schema(
        description = "Full name of the owner",
        example = "John Doe",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Schema(
        description = "Email address of the owner",
        example = "john.doe@example.com",
        format = "email",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;

    @NotBlank(message = "Phone is required")
    @Schema(
        description = "Phone number of the owner",
        example = "+1-555-1234",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String phone;

    @Schema(
        description = "List of addresses associated with the owner",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<OwnerAddressRequestDTO> ownerAddressDetails;
}
