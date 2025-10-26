package com.example.patient_management_system.mapper;

import com.example.patient_management_system.dto.PatientRequestDTO;
import com.example.patient_management_system.dto.PatientResponseDTO;
import com.example.patient_management_system.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    //PATIETNOBJECT TO PATIRNTERESPONSEDTO
    public static PatientResponseDTO toDTO (Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName (patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail (patient.getEmail());
        patientDTO.setDateofBirth (patient.getDateOfBirth().toString());
        return patientDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient=new Patient();
        patient.setName (patientRequestDTO.getName());
        patient.setAddress (patientRequestDTO.getAddress());
        patient.setEmail (patientRequestDTO.getEmail());
        patient.setDateOfBirth (LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegistrationDate(LocalDate.parse(patientRequestDTO.getRegistrationDate()));
        return patient;

    }
}
