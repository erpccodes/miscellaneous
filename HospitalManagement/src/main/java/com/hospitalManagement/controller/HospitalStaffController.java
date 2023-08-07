package com.hospitalManagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalManagement.entity.HospitalStaff;
import com.hospitalManagement.service.HospitalStaffService;

@RestController
@RequestMapping("/api")
public class HospitalStaffController {

	@Autowired
    private HospitalStaffService hospitalStaffService;

	  @PostMapping("/signup")
	    public ResponseEntity<?> signup(@RequestBody HospitalStaff staff) {
		  
		  // Check if username is already taken
	        if (hospitalStaffService.existsByUsername(staff.getUsername())) {
	        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Username already exists. Please choose a different username.");
	        }
		  
	        HospitalStaff newStaff = hospitalStaffService.signup(staff);
	        return ResponseEntity.ok(newStaff);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<HospitalStaff> login(@RequestBody Map<String, String> credentials) {
	        String username = credentials.get("username");
	        String password = credentials.get("password");
	        HospitalStaff staff = hospitalStaffService.login(username, password);
	        return ResponseEntity.ok(staff);
	    }
}
