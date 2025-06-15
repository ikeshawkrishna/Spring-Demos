package com.org.CommercialService.Controller;

import com.org.CommercialService.Service.PropertyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/property")
@Tag(name = "Property", description = "APIs Specific to Property will be available")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/getPropertyByOwnerId")
    @Operation(summary = "Get Properties of Owner Id")
    public ResponseEntity<?> getPropertyByOwnerId(@RequestParam("ownerId") Long ownerId) {
        return propertyService.getPropertyByOwnerId(ownerId);
    }

}
