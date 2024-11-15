package com.core;

import java.util.Scanner;

import com.daoImpl.AppointmentDAOImpl;
import com.daoImpl.DiseaseDAOImpl;
import com.daoImpl.DoctorDAOImpl;
import com.daoImpl.PatientDAOImpl;
import com.manage.ManageAppointment;
import com.manage.ManageDisease;
import com.manage.ManageDoctor;
import com.manage.ManagePatient;

public class App{
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
		PatientDAOImpl patientDAO = new PatientDAOImpl();
		AppointmentDAOImpl appointmentDAO = new AppointmentDAOImpl();
		DiseaseDAOImpl diseaseDAO = new DiseaseDAOImpl();
		
		boolean running = true;
		
		while(running) {
			System.out.println("\n--------------HOSPITAL MANAGEMENT SYSTEM------------");
			System.out.println("1. Manage Doctors");
			System.out.println("2. Manage Patients");
			System.out.println("3. Manage Appointments");
			System.out.println("4. Manage Diseases");
			System.out.println("5. Exit");
			
			System.out.print("\nSelect an option:");
			int choice = scr.nextInt();
			
			switch(choice) {
					case 1: 
						ManageDoctor Doctors = new ManageDoctor();
						Doctors.manageDoctor(doctorDAO, scr);
						break;
							
					case 2:
						ManagePatient patients = new ManagePatient();
						patients.managePatient(patientDAO, scr);
						break;
						
					case 3:
						ManageAppointment appointments = new ManageAppointment();
						appointments.manageAppointment(appointmentDAO, scr);
						break;
						
					case 4:
						ManageDisease diseases = new ManageDisease();
						diseases.manageDisease(diseaseDAO, scr);
						break;
						
					case 5: 
						running = false;
						System.out.println("Exiting the system. Goodbye!");
						break;
						
					default:
						System.out.println("Invalid choice, please try again.");
			}
		}
		
		scr.close();
	}
}