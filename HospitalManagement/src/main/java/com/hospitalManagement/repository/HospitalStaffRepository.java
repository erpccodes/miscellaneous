package com.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalManagement.entity.HospitalStaff;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long>{

    HospitalStaff findByUsername(String username);
    boolean existsByUsername(String username);
}
