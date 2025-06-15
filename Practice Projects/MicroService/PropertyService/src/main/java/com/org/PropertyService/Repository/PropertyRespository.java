package com.org.PropertyService.Repository;


import com.org.PropertyService.Entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRespository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {

    @Query(value = "select * from Property_Details where owner_id =:ownerid", nativeQuery = true)
    List<Property> findPropertyByOwnerId(@Param("ownerid") Long ownerId);
}
