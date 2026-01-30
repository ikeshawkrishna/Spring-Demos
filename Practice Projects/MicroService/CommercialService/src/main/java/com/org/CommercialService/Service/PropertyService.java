package com.org.CommercialService.Service;

import com.org.CommercialService.Feign.PropertyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    private PropertyFeign propertyFeign;

//    @Autowired
//    public PropertyService(PropertyFeign propertyFeign){
//        this.propertyFeign = propertyFeign;
//    }

    public ResponseEntity<?> getPropertyByOwnerId(Long ownerId) {
//        return propertyFeign.getPropertyByOwnerId(ownerId);
        return null;
    }


}
