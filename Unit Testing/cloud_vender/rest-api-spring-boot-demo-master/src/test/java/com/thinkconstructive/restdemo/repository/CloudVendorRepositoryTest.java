package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    CloudVendor vendor;
    @BeforeEach
    void setUp() {
        vendor = new CloudVendor("1","Amazon","Canada","9942566372");
        cloudVendorRepository.save(vendor);
    }

    @AfterEach
    void tearDown() {
        vendor = null;
        cloudVendorRepository.deleteAll();
    }

    //Success
    @Test
    void findByUsername_found(){
        List<CloudVendor> amazonList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(amazonList.get(0).getVendorId()).isEqualTo(vendor.getVendorId());
        assertThat(amazonList.get(0).getVendorName()).isEqualTo(vendor.getVendorName());
    }

    //Failure
    @Test
    void finByUsername_notFound(){
        List<CloudVendor> amazonList = cloudVendorRepository.findByVendorName("DLF");
        assertThat(amazonList.isEmpty()).isTrue();
    }

}
