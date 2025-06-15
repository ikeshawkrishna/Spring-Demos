package com.org.CommercialService.DTO.Response;

import com.org.CommercialService.Entity.Owner;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<OwnerAddressResponseDTO> ownerAddressDetails;

    public OwnerResponseDTO mapOwnerResponseDTO(Owner request){
        OwnerResponseDTO response = new OwnerResponseDTO();
        response.setId(request.getId());
        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setPhone(request.getPhone());

        List<OwnerAddressResponseDTO> addressDTOList = request.getOwnerAddressDetails().stream()
                .map(address -> {
                    OwnerAddressResponseDTO addressDTO = new OwnerAddressResponseDTO();
                    addressDTO.setAddressType(address.getAddressType());
                    addressDTO.setAddressLine1(address.getAddressLine1());
                    addressDTO.setAddressLine2(address.getAddressLine2());
                    addressDTO.setCity(address.getCity());
                    addressDTO.setState(address.getState());
                    addressDTO.setCountry(address.getCountry());
                    return addressDTO;
                })
                .collect(Collectors.toList());
        response.setOwnerAddressDetails(addressDTOList);

        return response;
    }

}
