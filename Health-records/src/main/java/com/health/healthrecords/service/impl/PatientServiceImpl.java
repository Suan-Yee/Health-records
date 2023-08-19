package com.health.healthrecords.service.impl;

import com.health.healthrecords.entity.Patient;
import com.health.healthrecords.exception.ResourceNotFoundException;
import com.health.healthrecords.repo.PatientRepo;
import com.health.healthrecords.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private PatientRepo patientRepo;

    @Override
    public Patient createPatient(Patient patient) {
        log.info(String.format("Saving new Patient Name: %s , DOB: %s",
                patient.getFirstName(),patient.getDateOfBirth()));
        return patientRepo.save(patient);
    }
    @Override
    public Patient retrievePatientByID(Long patientId) {
        log.info("Retrieving data:{}");
        return patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient","id",patientId));
    }
}
