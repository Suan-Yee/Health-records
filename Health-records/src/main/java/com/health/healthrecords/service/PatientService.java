package com.health.healthrecords.service;

import com.health.healthrecords.entity.Patient;

public interface PatientService {

    Patient createPatient(Patient patient);

    Patient retrievePatientByID(Long patientId);
}
