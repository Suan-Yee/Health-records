package com.health.healthrecords.repo;

import com.health.healthrecords.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    List<Doctor> findAllBySpecialization(String specialization);
}
