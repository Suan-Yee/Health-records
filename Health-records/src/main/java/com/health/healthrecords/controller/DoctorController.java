package com.health.healthrecords.controller;

import com.health.healthrecords.entity.Doctor;
import com.health.healthrecords.entity.Response;
import com.health.healthrecords.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/doctor")
public class DoctorController {

    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Response> saveDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .message("Saving new Doctor")
                        .data(Map.of("Saving",doctorService.createDoctor(doctor)))
                        .build()
        );
    }
    @GetMapping("{Sp}")
    public ResponseEntity<Response> findSpecialization(@PathVariable("Sp") String specialization){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK)
                        .message("Retrieving doctors on specialization")
                        .data(Map.of("Retrieve",doctorService.findDoctorBySpecialization(specialization)))
                        .build()
        );
    }
}
