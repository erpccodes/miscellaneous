package com.hospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.PatientStatus;
import com.hospitalManagement.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	  @Autowired
	    private PatientService patientService;

	    @PostMapping("/admit")
	    public ResponseEntity<String> admitPatient(@Valid @RequestBody Patient patient) {
	        try {
	            // Set default status to "admitted" when admitting a patient
	            patient.setStatus(PatientStatus.ADMITTED);
	            patientService.admitPatient(patient);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Patient admitted successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to admit patient.");
	        }
	    }

	    @GetMapping("/admitted")
	    public ResponseEntity<List<Patient>> getAdmittedPatients() {
	        List<Patient> admittedPatients = patientService.getAdmittedPatients();
	        return ResponseEntity.ok(admittedPatients);
	    }

	    @PutMapping("/discharge/{id}")
	    public ResponseEntity<String> dischargePatient(@PathVariable Long id) {
	        try {
	            Patient patient = patientService.getPatientById(id);
	            
	            if (patient == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
	            }
	            
	            // Set patient status to "discharged" when discharging
	            patient.setStatus(PatientStatus.DISCHARGED);
	            patientService.updatePatient(patient);
	            return ResponseEntity.ok("Patient discharged successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to discharge patient.");
	        }
	    }
}
