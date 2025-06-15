package com.org.PropertyService.Controller;



import com.org.PropertyService.DTO.PageResponse;
import com.org.PropertyService.DTO.PropertyDTO;
import com.org.PropertyService.Entity.Property;
import com.org.PropertyService.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping("/createProperty")
    public ResponseEntity<?> addProperty(@RequestBody PropertyDTO propertyRequestDTO) {
        PropertyDTO property = propertyService.createProperty(propertyRequestDTO);
        return ResponseEntity.ok(property);
    }

    @PutMapping("/updateProperty")
    public ResponseEntity<?> updateProperty(@RequestBody PropertyDTO propertyRequestDTO) {
        PropertyDTO property = propertyService.updateProperty(propertyRequestDTO);
        return ResponseEntity.ok(property);
    }

    @DeleteMapping("/deleteProperty/{propertyId}")
    public void deleteProperty(@PathVariable("propertyId") Long propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @GetMapping("/getPropertyByOwnerId")
    public ResponseEntity<?> getPropertyByOwnerId(@RequestParam("ownerId") Long ownerId) {
        List<PropertyDTO> propertyList = propertyService.getPropertyByOwnerId(ownerId);
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PostMapping("/searchProperties")
    public ResponseEntity<?> searchProperties(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer pagesize
    ){
        Page<Property> propertyList = propertyService.searchProperties(location, type, minPrice, maxPrice, offset, pagesize);
        return ResponseEntity.ok(new PageResponse<>(propertyList.getSize(),propertyList.getContent()));
    }

}
