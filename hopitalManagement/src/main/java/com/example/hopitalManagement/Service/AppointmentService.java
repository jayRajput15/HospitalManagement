package com.example.hopitalManagement.Service;

import com.example.hopitalManagement.entity.Appointment;
import com.example.hopitalManagement.entity.Doctor;
import com.example.hopitalManagement.entity.Patient;
import com.example.hopitalManagement.repository.AppointmentRepository;
import com.example.hopitalManagement.repository.DoctorRepository;
import com.example.hopitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
     public Appointment createAppointment(Appointment appointment, Long doctorId , Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        if(appointment.getId()!=null){
            throw new IllegalArgumentException("Appointment should not have a value");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        // This process is just for maintaining consistency
        patient.getAppointments().add(appointment);

       return  appointmentRepository.save(appointment);
    }

    @Transactional
     public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);  // This will automatically update the doctor as it is in dirty state

        doctor.getAppointments().add(appointment);  // This is just for bidirectional consistency

        return appointment;
    }
}
