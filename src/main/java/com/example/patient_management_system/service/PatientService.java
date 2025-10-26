package com.example.patient_management_system.service;

import com.example.patient_management_system.dto.PatientRequestDTO;
import com.example.patient_management_system.dto.PatientResponseDTO;
import com.example.patient_management_system.mapper.PatientMapper;
import com.example.patient_management_system.model.Patient;
import com.example.patient_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<PatientResponseDTO> getPatients () {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOS = patients.stream()
                .map(PatientMapper:: toDTO).toList();

        return patientResponseDTOS;
    }

    public PatientResponseDTO createPatients(PatientRequestDTO patientRequestDTO){
        // Check if email already exists
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new IllegalArgumentException(
                    "Email already registered: " + patientRequestDTO.getEmail()
            );
        }

        // Convert DTO to entity and save
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO)
        );
    //HERE IN SAVE WE CANNOT DIRECTLY PASS PATIRNTREQUESTDTO WEE NEED TO GO TO MAPEPER AND CONVERT TO ENTITY MODEL OBJECT
        return PatientMapper.toDTO(newPatient);
    }
}
