package com.entities;

import java.sql.Time;
import java.sql.Date;

public class Appointment {
	private int appointmentId;
	private int doctorId;
	private int patientId;
	private Date appointmentDate;
	private Time appointmentTime;
	
	public Appointment(int doctorId, int patientId, Date appointmentDate, Time appointmentTime) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}
	
	public Appointment() {
		super();
	}
	
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	
	@Override
	public String toString() {
		return "Appointment [Id: "+appointmentId+", Doctor ID: "+doctorId+", Patient ID: "+patientId+", Date: "+appointmentDate+", Time: "+appointmentTime+"]";
	}
}
