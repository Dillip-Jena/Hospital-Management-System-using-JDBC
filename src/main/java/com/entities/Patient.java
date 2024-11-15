package com.entities;

public class Patient {
	private int patientId;
	private String name;
	private int age;
	private String contactNumber;
	private String address;
	
	public Patient(String name, int age, String contactNumber, String address) {
		super();
		this.name = name;
		this.age = age;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public Patient() {
		super();
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "Patient [Id: "+patientId+", Name: "+name+", Age: "+age+", Contact no: "+contactNumber+", Address: "+address+"]";
	}
}
