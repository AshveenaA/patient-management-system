package com.example.patient_management_system.mapper;

import com.example.patient_management_system.dto.PatientResponseDTO;
import com.example.patient_management_system.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO (Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName (patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail (patient.getEmail());
        patientDTO.setDateofBirth (patient.getDateOBirth().toString());
        return patientDTO;
    }
}
