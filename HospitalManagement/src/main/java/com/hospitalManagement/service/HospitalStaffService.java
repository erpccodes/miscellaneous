package com.hospitalManagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hospitalManagement.entity.HospitalStaff;
import com.hospitalManagement.repository.HospitalStaffRepository;

@Service
public class HospitalStaffService implements UserDetailsService{
	private final HospitalStaffRepository hospitalStaffRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public HospitalStaffService(HospitalStaffRepository hospitalStaffRepository, PasswordEncoder passwordEncoder) {
        this.hospitalStaffRepository = hospitalStaffRepository;
        this.passwordEncoder = passwordEncoder;
    }

	 public HospitalStaff signup(HospitalStaff staff) {
		 staff.setPassword(passwordEncoder.encode(staff.getPassword()));
	        return hospitalStaffRepository.save(staff);
	        }
	 
	 public boolean existsByUsername(String username) {
	        return hospitalStaffRepository.existsByUsername(username);
	    }

	    public HospitalStaff login(String username, String password) {
	        HospitalStaff staff = hospitalStaffRepository.findByUsername(username);
	        if (staff != null && passwordEncoder.matches(password, staff.getPassword())) {
	            return staff;
	        }
	        throw new RuntimeException("Invalid username or password");
	    }

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			HospitalStaff staff = hospitalStaffRepository.findByUsername(username);
	        if (staff == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new User(staff.getUsername(), staff.getPassword(), new ArrayList<>());
		}
}
