package com.org.CommercialService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity(name = "OwnerAddressDetails")
@Data
@NoArgsConstructor
@ToString
public class OwnerAddressDetails {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_address_seq")
//    @SequenceGenerator(name = "owner_address_seq", sequenceName = "owner_address_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String addressType;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;

    @ToString.Exclude
    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public OwnerAddressDetails(String addressType, String addressLine1, String addressLine2, String city, String state, String country, Owner owner) {
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.owner = owner;
    }
}
