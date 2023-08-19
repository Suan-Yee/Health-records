package com.health.healthrecords.controller;

import com.health.healthrecords.entity.Patient;
import com.health.healthrecords.entity.Response;
import com.health.healthrecords.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/patient")
public class PatientController {

    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Response> savePatient(@RequestBody Patient patient){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Saving",patientService.createPatient(patient)))
                        .message("Saving new Patient")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<Response> retrievePatient(@PathVariable("id") @Valid Long patientId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("Retrieving",patientService.retrievePatientByID(patientId)))
                        .message("Retrieving Patient By ID")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
