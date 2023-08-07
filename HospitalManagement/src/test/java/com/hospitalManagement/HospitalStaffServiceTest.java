package com.hospitalManagement;

import static org.mockito.Mockito.*;

import com.hospitalManagement.entity.HospitalStaff;
import com.hospitalManagement.repository.HospitalStaffRepository;
import com.hospitalManagement.service.HospitalStaffService;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalStaffServiceTest {

    @Test
    public void testSignup() {
        HospitalStaffRepository mockRepository = mock(HospitalStaffRepository.class);
        PasswordEncoder mockPasswordEncoder = mock(PasswordEncoder.class);
        
        HospitalStaffService hospitalStaffService = new HospitalStaffService(mockRepository, mockPasswordEncoder);

        HospitalStaff staff = new HospitalStaff();
        staff.setUsername("testUser");
        staff.setPassword("testPassword");

        when(mockPasswordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(mockRepository.save(any(HospitalStaff.class))).thenReturn(staff);

        HospitalStaff result = hospitalStaffService.signup(staff);

        assertNotNull(result);
        assertEquals("encodedPassword", result.getPassword());
        verify(mockRepository, times(1)).save(any(HospitalStaff.class));
    }

    @Test
    public void testLogin_ValidCredentials() {
        HospitalStaffRepository mockRepository = mock(HospitalStaffRepository.class);
        PasswordEncoder mockPasswordEncoder = mock(PasswordEncoder.class);

        HospitalStaffService hospitalStaffService = new HospitalStaffService(mockRepository, mockPasswordEncoder);

        HospitalStaff staff = new HospitalStaff();
        staff.setUsername("testUser");
        staff.setPassword("encodedPassword");

        when(mockRepository.findByUsername(anyString())).thenReturn(staff);
        when(mockPasswordEncoder.matches(anyString(), anyString())).thenReturn(true);

        HospitalStaff result = hospitalStaffService.login("testUser", "testPassword");

        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
    }

    @Test
    public void testLogin_InvalidCredentials() {
        HospitalStaffRepository mockRepository = mock(HospitalStaffRepository.class);
        PasswordEncoder mockPasswordEncoder = mock(PasswordEncoder.class);

        HospitalStaffService hospitalStaffService = new HospitalStaffService(mockRepository, mockPasswordEncoder);

        when(mockRepository.findByUsername(anyString())).thenReturn(null);

        assertThrows(RuntimeException.class, () -> hospitalStaffService.login("testUser", "testPassword"));
    }
}