package com.org.CommercialService.Entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "Owner_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq")
//    @SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String name;
    private String email;
    private String phone;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<OwnerAddressDetails> ownerAddressDetails = new ArrayList<>();

}
