package com.example.hopitalManagement.Service;

import com.example.hopitalManagement.entity.Insurance;
import com.example.hopitalManagement.entity.Patient;
import com.example.hopitalManagement.repository.InsuranceRepository;
import com.example.hopitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
     public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
         Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("patient not found with id: "+patientId));
         patient.setInsurance(insurance);
         insurance.setPatient(patient); // TO MAINTAIN BIDIRECTIONAL CONSISTENCY
         return patient;
     }

     @Transactional
     public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->
                new EntityNotFoundException("Patient does not exist with ID: "+patientId));

        patient.setInsurance(null);
        return patient;
     }


}
