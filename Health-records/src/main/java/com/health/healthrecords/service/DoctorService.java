package com.health.healthrecords.service;

import com.health.healthrecords.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);
    List<Doctor> findDoctorBySpecialization(String specialization);
}
