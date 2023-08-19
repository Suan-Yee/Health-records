package com.health.healthrecords.service.impl;

import com.health.healthrecords.entity.Doctor;
import com.health.healthrecords.exception.SpecializationNotFoundError;
import com.health.healthrecords.repo.DoctorRepo;
import com.health.healthrecords.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepo doctorRepo;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        log.info("Saving new Doctor " +doctor.getFirstName());
        return  doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> findDoctorBySpecialization(String specialization) {
        List<Doctor> doctorList = doctorRepo.findAllBySpecialization(specialization);

        if(doctorList.isEmpty()){
            throw new SpecializationNotFoundError("Doctor",specialization);
        }
        return doctorList;
    }

}
