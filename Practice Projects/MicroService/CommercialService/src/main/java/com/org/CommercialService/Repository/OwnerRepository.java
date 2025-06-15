package com.org.CommercialService.Repository;

import com.org.CommercialService.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query(value = "select count(*) as usercount from owner_details where phone  =:phone or email =:email", nativeQuery = true)
    int findExistingUser(@Param("phone") String phone, @Param("email") String email);

}
