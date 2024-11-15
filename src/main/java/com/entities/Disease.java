package com.entities;

public class Disease {
	private int diseaseId;
	private int patientId;
	private String diseaseName;
	private String status;
	private String patientName;
	private int patientAge;
	
	public Disease(int diseaseId, int patientId, String diseaseName, String status, String patientName, int patientAge) {
		super();
		this.diseaseId = diseaseId;
		this.patientId = patientId;
		this.diseaseName = diseaseName;
		this.status = status;
		this.patientName = patientName;
		this.patientAge = patientAge;
	}
	
	public Disease() {
		super();
	}
	
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	
	public int getDiseaseId() {
		return diseaseId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	
	public String getDiseaseName() {
		return diseaseName;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	public int getPatientAge() {
		return patientAge;
	}
	
	@Override
	public String toString() {
		return "Disease [ID: "+diseaseId+", Patient ID: "+patientId+", Disease :"+diseaseName+", Status: "+status+"]";
	}
}