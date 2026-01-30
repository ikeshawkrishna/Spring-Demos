package com.org.CommercialService.Feign;

import com.org.CommercialService.DTO.PropertyDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "property-service")
public interface PropertyFeign {

    @GetMapping("/getPropertyByOwnerId")
    public ResponseEntity<List<PropertyDTO>> getPropertyByOwnerId(@RequestParam("ownerId") Long ownerId);

}
