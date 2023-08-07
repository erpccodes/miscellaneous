package com.hospitalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.PatientStatus;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    List<Patient> findByStatus(PatientStatus status);

}
