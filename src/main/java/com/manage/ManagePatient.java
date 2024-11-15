package com.manage;

import java.util.List;
import java.util.Scanner;

import com.dao.PatientDAO;
import com.entities.Patient;

public class ManagePatient {
	public void managePatient(PatientDAO patientDAO, Scanner scr) {
		boolean managePatientRunning = true;
		
		while(managePatientRunning) {
			System.out.println("\n-------------Manage Patients--------------");
			System.out.println("1. Add Patient");
			System.out.println("2. View All Patients");
			System.out.println("3. View Patient by ID");
			System.out.println("4. Update Patient");
			System.out.println("5. Delete Patient");
			System.out.println("6. Go Back to Main Menu");
			
			System.out.print("\nSelect an option: ");
			int choice = scr.nextInt();
			
			switch(choice) {
					case 1:
							Patient newPatient = new Patient();
							
							System.out.print("Enter patient name: ");
							newPatient.setName(scr.next());
							System.out.print("Enter patient age: ");
							newPatient.setAge(scr.nextInt());
							System.out.print("Enter contact number: ");
							newPatient.setContactNumber(scr.next());
							System.out.print("Enter address: ");
							newPatient.setAddress(scr.next());
							
							patientDAO.addPatient(newPatient);
							break;
							
					case 2:
							List<Patient> patients = patientDAO.getAllPatients();
							System.out.println("+----------+-------------------+--------+------------------+---------------------+");
							System.out.println("|    ID    |       Name        |  Age   |    Contact no    |       Address       |");
							System.out.println("+----------+-------------------+--------+------------------+---------------------+");
							for(Patient patient : patients) {
								System.out.printf("|     %-5d|       %-12s|   %-5d|    %-14s|       %-14s|\n", patient.getPatientId(), patient.getName(), patient.getAge(), patient.getContactNumber(), patient.getAddress());
								System.out.println("+----------+-------------------+--------+------------------+---------------------+");
							}
							break;
							
					case 3: 
							System.out.print("Enter patient ID: ");
							int patientId = scr.nextInt();
							
							Patient patient = patientDAO.getPatientById(patientId);
							if(patient != null) {
								System.out.println("+----------+-------------------+--------+------------------+---------------------+");
								System.out.println("|    ID    |       Name        |  Age   |    Contact no    |       Address       |");
								System.out.println("+----------+-------------------+--------+------------------+---------------------+");
								System.out.printf("|     %-5d|       %-12s|   %-5d|    %-14s|       %-14s|\n", patient.getPatientId(), patient.getName(), patient.getAge(), patient.getContactNumber(), patient.getAddress());
								System.out.println("+----------+-------------------+--------+------------------+---------------------+");
							}
							else {
								System.out.println("Patient not found");
							}
							break;
							
					case 4:
							Patient updatePatient = new Patient();
							
							System.out.print("Enter patient ID to update: ");
							updatePatient.setPatientId(scr.nextInt());
							System.out.print("Enter new patient name: ");
							updatePatient.setName(scr.next());
							System.out.print("Enter new age: ");
							updatePatient.setAge(scr.nextInt());
							System.out.print("Enter new contact number: ");
							updatePatient.setContactNumber(scr.next());
							System.out.print("Enter new address: ");
							updatePatient.setAddress(scr.next());
							
							patientDAO.updatePatient(updatePatient);
							break;
							
					case 5:
							System.out.print("Enter patient ID to delete: ");
							int deletePatientId = scr.nextInt();
							
							patientDAO.deletePatient(deletePatientId);
							break;
							
					case 6: 
							managePatientRunning = false;
							System.out.println("Returning to the main menu....");
							break;
							
					default:
							System.out.println("Invalid option.");		
			}
		}
	}
}
