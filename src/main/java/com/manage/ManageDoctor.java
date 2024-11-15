package com.manage;

import java.util.List;
import java.util.Scanner;

import com.dao.DoctorDAO;
import com.entities.Doctor;

public class ManageDoctor {
	public void manageDoctor(DoctorDAO doctorDAO, Scanner scr) {
		boolean manageDoctorRunning = true;
		
		while(manageDoctorRunning) {
			System.out.println("\n----------------Manage Doctors------------");
			System.out.println("1. Add Doctor");
			System.out.println("2. View All Doctors");
			System.out.println("3. View Doctor by ID");
			System.out.println("4. Update Doctor");
			System.out.println("5. Delete Doctor");
			System.out.println("6. Go Back to Main Menu");
			
			System.out.print("\nSelect an option:");
			int choice = scr.nextInt();
			
			switch(choice) {
				case 1:
						Doctor newdoctor = new Doctor();
						
						System.out.print("Enter doctor name: ");
						newdoctor.setName(scr.next());
						System.out.print("Enter specialization: ");
						newdoctor.setSpecialization(scr.next());
						System.out.print("Enter contact number: ");
						newdoctor.setContactNumber(scr.next());
						
						doctorDAO.addDoctor(newdoctor);
						break;
						
				case 2:
						List<Doctor> doctors = doctorDAO.getAllDoctors();
						System.out.println("+--------------+------------------+-----------------------+-------------------+");
						System.out.println("|    ID        |      Name        |    Specialization     |     Contact no    |");
						System.out.println("+--------------+------------------+-----------------------+-------------------+");
						for(Doctor doctor : doctors) {
							System.out.printf("|     %-9d|     %-13s|     %-18s|     %-14s|\n",doctor.getDoctorId(), doctor.getName(), doctor.getSpecialization(), doctor.getContactNumber());
							System.out.println("+--------------+------------------+-----------------------+-------------------+");
						}
						break;
						
				case 3: 
						System.out.print("Enter doctor ID: ");
						int doctorId = scr.nextInt();
						
						Doctor doctor = doctorDAO.getDoctorById(doctorId);
						if(doctor != null) {
							System.out.println("+--------------+------------------+-----------------------+-------------------+");
							System.out.println("|    ID        |      Name        |    Specialization     |     Contact no    |");
							System.out.println("+--------------+------------------+-----------------------+-------------------+");
							System.out.printf("|     %-9d|     %-13s|     %-18s|     %-14s|\n",doctor.getDoctorId(), doctor.getName(), doctor.getSpecialization(), doctor.getContactNumber());
							System.out.println("+--------------+------------------+-----------------------+-------------------+");
						}
						else {
							System.out.println("Doctor not found.");
						}
						break;
						
				case 4:
						Doctor updateDoctor = new Doctor();
						
						System.out.print("Enter doctor ID to update: ");
						updateDoctor.setDoctorId(scr.nextInt());
						System.out.print("Enter new doctor name: ");
						updateDoctor.setName(scr.next());
						System.out.print("Enter new specialization: ");
						updateDoctor.setSpecialization(scr.next());
						System.out.print("Enter new contact number: ");
						updateDoctor.setContactNumber(scr.next());
						
						doctorDAO.updateDoctor(updateDoctor);
						break;
						
				case 5:
						System.out.print("Enter doctor ID to delete: ");
						int deleteDoctorId = scr.nextInt();
						
						doctorDAO.deleteDoctor(deleteDoctorId);
						break;
						
				case 6:
						manageDoctorRunning = false;
						System.out.println("Returning to the main menu...");
						break;
						
				default:
						System.out.println("Invalid option.");
			}
		}
	}
}
