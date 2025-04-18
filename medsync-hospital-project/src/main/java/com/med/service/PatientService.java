package com.med.service;

import java.util.List;

import com.med.dto.PatientDetailsDTO;
import com.med.dto.RegisterPatientDTO;

public interface PatientService {
	
    public PatientDetailsDTO savePatient(RegisterPatientDTO patientDto);
    
    public PatientDetailsDTO updatePatient(String patientId, RegisterPatientDTO patientDto);
    
    public PatientDetailsDTO getPatientDetails(String patientId);
    
    public List<PatientDetailsDTO> getAllPatientDetails();
    
    public List<PatientDetailsDTO> getPatientsByName(String name);
    
    public void deletePatient(String patientId);

	public PatientDetailsDTO getPatientByPhone(String phoneNumber);
    
    

}

