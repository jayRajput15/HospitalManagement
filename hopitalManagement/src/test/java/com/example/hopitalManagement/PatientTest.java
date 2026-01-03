package com.example.hopitalManagement;


import com.example.hopitalManagement.Service.PatientService;
import com.example.hopitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.hopitalManagement.entity.Patient;
import com.example.hopitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;


       @Test
    public void patientRepositoryTest(){
       List<Patient> patientList =  patientRepository.findAll();

       System.out.print(patientList);

       }

       @Test
    public void testTransactionMethod() {
           //   Patient patient = patientService.getPatientById(1L);
           //Patient patient = patientRepository.findByName("Sanskar");
         //  List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2002, 8, 15), "veer07@gmail.com");
           //List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("S");
          // List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(2002,8,15));
//           List<Patient> patientList = patientRepository.findAllPatient();
//           for (Patient patient : patientList) {
//               System.out.println(patient);
//           }
//
//           List<Object[]> bloodGroupList = patientRepository.countEachBloodGrouptype();
//           for(Object[] objects : bloodGroupList){
//               System.out.println(objects[0]+"->"+objects[1]);
//           }
//
//           int rowUpdated = patientRepository.updateNameWithID("Jay Rajput",1L);
//           System.out.print(rowUpdated);
//           List<Patient> listofPatients = patientRepository.findGenderAndBloodgroup("Male",BloodGroup.valueOf("O_POSITIVE"));
//           for(Patient patients : listofPatients){
//               System.out.println(patients);
//           }

           //
           List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroup();
           for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
               System.out.println(bloodGroupCountResponse);
           }
       }



}
