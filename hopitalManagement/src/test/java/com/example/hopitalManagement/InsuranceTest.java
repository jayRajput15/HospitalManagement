package com.example.hopitalManagement;


import com.example.hopitalManagement.Service.InsuranceService;
import com.example.hopitalManagement.entity.Insurance;
import com.example.hopitalManagement.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder().policyNumber("HDFC_1234").provider("HDFC").validUntil(LocalDate.of(2003,12,4)).build();
        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

       var newPatient =  insuranceService.disaccociateInsuranceFromPatient(patient.getId());
       System.out.println(patient);
    }

}
