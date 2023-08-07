package com.hospitalManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.PatientStatus;
import com.hospitalManagement.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepository;
	  
	  @Autowired
	  public PatientService(PatientRepository patientRepository) {
	      this.patientRepository = patientRepository;
	  }
	  

	    public void admitPatient(Patient patient) {
	        patientRepository.save(patient);
	    }

	    public List<Patient> getAdmittedPatients() {
	        return patientRepository.findByStatus(PatientStatus.ADMITTED);
	    }

	    public Patient getPatientById(Long id) {
	        Optional<Patient> optionalPatient = patientRepository.findById(id);
	        return optionalPatient.orElse(null);
	    }

	    public void updatePatient(Patient patient) {
	        patientRepository.save(patient);
	    }
}
