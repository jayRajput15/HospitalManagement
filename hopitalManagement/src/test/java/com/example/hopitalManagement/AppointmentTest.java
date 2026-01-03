package com.example.hopitalManagement;

import com.example.hopitalManagement.Service.AppointmentService;
import com.example.hopitalManagement.Service.PatientService;
import com.example.hopitalManagement.entity.Appointment;
import com.example.hopitalManagement.entity.Patient;
import com.example.hopitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2025,11,2,4,30)).reason("Cancer").build();

        var newAppointment = appointmentService.createAppointment(appointment,1L,2L);

        System.out.println(newAppointment);

        var updateAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
        System.out.println(updateAppointment);
    }

    @Test
    public void testCreateAppointmentDeletePatient(){
        Appointment a1 = Appointment.builder().appointmentTime(LocalDateTime.of(2025,9,4,3,45)).reason("Jaundice").build();
        Appointment a2 = Appointment.builder().appointmentTime(LocalDateTime.of(2025,10,15,8,55)).reason("Dengue").build();
        Appointment a3 = Appointment.builder().appointmentTime(LocalDateTime.of(2025,4,3,6,25)).reason("Tuberculosis").build();

        appointmentService.createAppointment(a1,1L,1L);
        appointmentService.createAppointment(a2,2L,1L);
        appointmentService.createAppointment(a3,3L,1L);

       patientRepository.deleteById(1L);


    }
}
