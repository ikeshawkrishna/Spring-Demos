package com.org.PropertyService.Service;

import com.org.PropertyService.DTO.PropertyDTO;
import com.org.PropertyService.Entity.Property;
import com.org.PropertyService.Exception.PropertyNotFound;
import com.org.PropertyService.Repository.PropertyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRespository propertyRespository;

    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = new Property(
                propertyDTO.getTitle(),
                propertyDTO.getDescription(),
                propertyDTO.getType(),
                propertyDTO.getLocation(),
                propertyDTO.getPrice(),
                propertyDTO.getStatus(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                propertyDTO.getOwnerId(),
                propertyDTO.getAdvancePayment()
        );

        Property save = propertyRespository.save(property);

        return PropertyDTO.mapResponse(save);
    }

    public PropertyDTO updateProperty(PropertyDTO propertyDTO) {
        Property property = propertyRespository.findById(propertyDTO.getId())
                .orElseThrow(() -> new PropertyNotFound("Property not found to update."));

        property.setId(propertyDTO.getId());
        property.setTitle(propertyDTO.getTitle());
        property.setDescription(propertyDTO.getDescription());
        property.setType(propertyDTO.getType());
        property.setLocation(propertyDTO.getLocation());
        property.setPrice(propertyDTO.getPrice());
        property.setStatus(propertyDTO.getStatus());
        property.setUpdatedAt(LocalDateTime.now());
        property.setAdvancePayment(propertyDTO.getAdvancePayment());

        propertyRespository.save(property);
        return PropertyDTO.mapResponse(property);
    }

    public void deleteProperty(Long propertyId) {
        propertyRespository.deleteById(propertyId);
    }

    public List<PropertyDTO> getPropertyByOwnerId(Long ownerId) {
        List<Property> propertyList = propertyRespository.findPropertyByOwnerId(ownerId);

        List<PropertyDTO> PropertyDTOList = new ArrayList<>();
        for (Property property : propertyList) {
            PropertyDTO propertyDTO = PropertyDTO.mapResponse(property);
            PropertyDTOList.add(propertyDTO);
        }
        return PropertyDTOList;
    }

    public Page<Property> searchProperties(String location, String type, Double minPrice, Double maxPrice, int offset, int pagesize) {
        Specification<Property> spec = Specification.allOf();

        if(location != null && !location.isBlank()){
            spec.and(hasLocation(location));
        }

        if(type != null && !type.isBlank()){
            spec.and(hastype(type));
        }

        if(minPrice != null && maxPrice != null){
            spec.and(hasPrice(minPrice, maxPrice));
        }

        Pageable pageable = PageRequest.of(offset, pagesize);
        Page<Property> pageValues = propertyRespository.findAll(spec, pageable);
        return pageValues;
    }

    private Specification<Property> hasLocation(String location){
        return (root, query, cb) ->
                cb.like((root.get("location")), "%" + location + "%");
    }

    private Specification<Property> hastype(String type){
        return (root, query, cb) ->
                cb.equal((root.get("type")), type);
    }

    private Specification<Property> hasPrice(Double min, Double max){
        return (root, query, cb) ->
                cb.between(root.get("price"), min, max + 1);
    }
}
