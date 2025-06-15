package com.org.CommercialService.Controller;

import com.org.CommercialService.DTO.Request.OwnerRequestDTO;
import com.org.CommercialService.DTO.Response.OwnerResponseDTO;
import com.org.CommercialService.Service.OwnerService;
import com.org.CommercialService.Service.PropertyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/owner")
@Tag(name = "Owner", description = "APIs Specific to Owner will be available")
public class OwnerController {

    private final OwnerService ownerService;
    private final PropertyService propertyService;

    @Autowired
    public OwnerController(OwnerService ownerService, PropertyService propertyService) {
        this.ownerService = ownerService;
        this.propertyService = propertyService;
    }

    @PostMapping("/register")
    @Operation(summary = "Resgister Owner")
    public ResponseEntity<?> registerOwner(@Valid @RequestBody OwnerRequestDTO ownerRequestDTO) {
        System.out.println("ownerRequestDTO >> " + ownerRequestDTO);
        OwnerResponseDTO responseDTO = ownerService.registerOwner(ownerRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

}
