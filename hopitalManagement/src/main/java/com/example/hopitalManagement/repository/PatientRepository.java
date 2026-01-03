package com.example.hopitalManagement.repository;

import com.example.hopitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.hopitalManagement.entity.Patient;
import com.example.hopitalManagement.entity.type.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
   // List<Patient> findByNameContaining(String query);
    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodgroup(@Param("bloodGroup") BloodGroup bloodGroup);
    //List<BloodGroupCountResponseEntity> countEachBloodGroupType();

     @Query("SELECT p FROM Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);


     @Query("SELECT new com.example.hopitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup , Count(p))from Patient p group by p.bloodGroup")
     //List<Object[]> countEachBloodGrouptype();
   List<BloodGroupCountResponseEntity>  countEachBloodGroup();

     @Query(value = "SELECT * FROM patient",nativeQuery = true)
     List<Patient> findAllPatient();

     // UPDATE Query
     @Transactional
      @Modifying
     @Query("update Patient p SET p.name = :name where p.id= :id")
     int updateNameWithID(@Param("name") String name, @Param("id") Long id);

     //FIND PATIENT BY GENDER AND BLOOD GROUP
     @Query("SELECT p FROM Patient p where p.gender= :gender AND p.bloodGroup= :bloodGroup")
    List<Patient> findGenderAndBloodgroup(@Param("gender") String gender , @Param("bloodGroup") BloodGroup bloodGroup);
}
