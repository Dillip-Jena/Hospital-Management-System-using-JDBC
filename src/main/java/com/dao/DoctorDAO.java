package com.dao;

import java.util.List;

import com.entities.Doctor;

public interface DoctorDAO {
	void addDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getDoctorById(int doctorId);
	void updateDoctor(Doctor doctor);
	void deleteDoctor(int doctorId);
}
