package com.dao;

import java.util.List;

import com.entities.Patient;

public interface PatientDAO {
	void addPatient(Patient patient);
	List<Patient> getAllPatients();
	Patient getPatientById(int patientId);
	void updatePatient(Patient patient);
	void deletePatient(int patientId);
}
