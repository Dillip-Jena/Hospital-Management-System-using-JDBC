package com.entities;

public class Doctor {
	private int doctorId;
	private String name;
	private String specialization;
	private String contactNumber;
	
	public Doctor(String name, String specialization, String contactNumber) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.contactNumber = contactNumber;
	}
	
	public Doctor() {
		super();
	}
	
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	@Override
	public String toString() {
		return "Doctor [Id: "+doctorId+", Name: "+name+", Specialization: "+specialization+", Contact no: "+contactNumber+"]";
	}
}
