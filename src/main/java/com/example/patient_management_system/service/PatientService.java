package com.example.patient_management_system.service;

import com.example.patient_management_system.dto.PatientResponseDTO;
import com.example.patient_management_system.mapper.PatientMapper;
import com.example.patient_management_system.model.Patient;
import com.example.patient_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

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


}
