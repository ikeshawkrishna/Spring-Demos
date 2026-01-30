package com.org.CommercialService.Service;


import com.org.CommercialService.DTO.Request.OwnerRequestDTO;
import com.org.CommercialService.DTO.Response.OwnerResponseDTO;
import com.org.CommercialService.Entity.Owner;
import com.org.CommercialService.Entity.OwnerAddressDetails;
import com.org.CommercialService.Exception.UserAlreadyExist;
//import com.org.CommercialService.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

//    @Autowired
//    OwnerRepository ownerRepository;

    public OwnerResponseDTO registerOwner(OwnerRequestDTO ownerRequestDTO) {
        String phone = ownerRequestDTO.getPhone();
        String email = ownerRequestDTO.getEmail();
//        int ownerCount = ownerRepository.findExistingUser(phone, email);
//        if(ownerCount != 0){
//            throw new UserAlreadyExist("User is already exist");
//        }

        Owner owner = new Owner();
        owner.setName(ownerRequestDTO.getName());
        owner.setEmail(ownerRequestDTO.getEmail());
        owner.setPhone(ownerRequestDTO.getPhone());
        owner.setCreatedAt(LocalDateTime.now());
        owner.setUpdatedAt(LocalDateTime.now());

        List<OwnerAddressDetails> addressList = ownerRequestDTO.getOwnerAddressDetails().stream()
                .map((address -> {
                    OwnerAddressDetails addressDetails = new OwnerAddressDetails(
                            address.getAddressType(),
                            address.getAddressLine1(),
                            address.getAddressLine2(),
                            address.getCity(),
                            address.getState(),
                            address.getCountry(),
                            owner
                    );
                    return addressDetails;
                }))
                .collect(Collectors.toList());
        owner.setOwnerAddressDetails(addressList);


//        Owner savedOwner = ownerRepository.save(owner);
        Owner savedOwner = owner;
        System.out.println("savedOwner >> " + savedOwner);

        return new OwnerResponseDTO().mapOwnerResponseDTO(savedOwner);
    }

//    public List<Property> getPropertyByOwnerName(String ownername) {
//
//        return null;
//    }
}
