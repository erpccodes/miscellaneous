package com.hospitalManagement;
import static org.mockito.Mockito.*;

import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.PatientStatus;
import com.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.service.PatientService;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PatientServiceTest {

    @Test
    public void testAdmitPatient() {
        PatientRepository mockRepository = mock(PatientRepository.class);
        PatientService patientService = new PatientService(mockRepository);

        Patient patient = new Patient();
        patient.setName("John Doe");

        patientService.admitPatient(patient);

        verify(mockRepository, times(1)).save(any(Patient.class));
    }

    @Test
    public void testGetAdmittedPatients() {
        PatientRepository mockRepository = mock(PatientRepository.class);
        PatientService patientService = new PatientService(mockRepository);

        List<Patient> expectedPatients = new ArrayList<>();
        expectedPatients.add(new Patient());

        when(mockRepository.findByStatus(any(PatientStatus.class))).thenReturn(expectedPatients);

        List<Patient> result = patientService.getAdmittedPatients();

        assertNotNull(result);
        assertEquals(expectedPatients.size(), result.size());
    }

    @Test
    public void testGetPatientById_ValidId() {
        PatientRepository mockRepository = mock(PatientRepository.class);
        PatientService patientService = new PatientService(mockRepository);

        Patient expectedPatient = new Patient();

        when(mockRepository.findById(anyLong())).thenReturn(Optional.of(expectedPatient));

        Patient result = patientService.getPatientById(1L);

        assertNotNull(result);
        assertEquals(expectedPatient, result);
    }

    @Test
    public void testGetPatientById_InvalidId() {
        PatientRepository mockRepository = mock(PatientRepository.class);
        PatientService patientService = new PatientService(mockRepository);

        when(mockRepository.findById(anyLong())).thenReturn(Optional.empty());

        Patient result = patientService.getPatientById(1L);

        assertNull(result);
    }

    @Test
    public void testUpdatePatient() {
        PatientRepository mockRepository = mock(PatientRepository.class);
        PatientService patientService = new PatientService(mockRepository);

        Patient patient = new Patient();
        patient.setId(1L);

        patientService.updatePatient(patient);

        verify(mockRepository, times(1)).save(any(Patient.class));
    }
}