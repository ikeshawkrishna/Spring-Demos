package com.org.PropertyService.DTO;

import com.org.PropertyService.Entity.Property;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Builder;
import lombok.Data;

@Data
public class PropertyDTO {
    @Hidden
    private Long id;
    private String title;
    private String description;
    private String type; // e.g., "Office", "Warehouse", "Retail"
    private String location;
    private Double price;
    private String status;
    private Double advancePayment;
    private Long ownerId;

    public static PropertyDTO mapResponse(Property reponse){
        PropertyDTO responseDTO = new PropertyDTO();
        responseDTO.setId(reponse.getId());
        responseDTO.setTitle(reponse.getTitle());
        responseDTO.setDescription(reponse.getDescription());
        responseDTO.setType(reponse.getType());
        responseDTO.setLocation(reponse.getLocation());
        responseDTO.setPrice(reponse.getPrice());
        responseDTO.setStatus(reponse.getStatus());
        responseDTO.setAdvancePayment(reponse.getAdvancePayment());
        responseDTO.setOwnerId(reponse.getOwnerId());
        return responseDTO;
    }
}
