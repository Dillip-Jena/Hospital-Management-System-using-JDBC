package com.dao;

import java.util.List;

import com.entities.Appointment;

public interface AppointmentDAO {
	void addAppointment(Appointment appointment);
	List<Appointment> getAllAppointment();
	Appointment getAppointmentById(int appointmentId);
	void updateAppointment(Appointment appointment);
	void deleteAppointment(int appointmentId);
}
