package com.manage;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.dao.AppointmentDAO;
import com.entities.Appointment;

public class ManageAppointment {
	public void manageAppointment(AppointmentDAO appointmentDAO, Scanner scr) {
		boolean manageAppointmentRunning = true;
		
		while(manageAppointmentRunning) {
			System.out.println("\n------------Manage Appointments-------------");
			System.out.println("1. Add Appointment");
			System.out.println("2. View All Appointments");
			System.out.println("3. View Appointment by ID");
			System.out.println("4. Update Appointment");
			System.out.println("5. Delete Appointment");
			System.out.println("6. Go Back to main menu");
			
			System.out.print("\nSelect an option: ");
			int choice = scr.nextInt();
			
			switch(choice) {
					case 1: 
							Appointment newAppointment = new Appointment();
							
							System.out.print("Enter doctor ID: ");
							newAppointment.setDoctorId(scr.nextInt());
							System.out.print("Enter patient ID: ");
							newAppointment.setPatientId(scr.nextInt());
							System.out.print("Enter appointment date (YYYY-MM-DD): ");
							newAppointment.setAppointmentDate(Date.valueOf(scr.next()));
							System.out.print("Enter appointment time (HH:MM:SS): ");
							newAppointment.setAppointmentTime(Time.valueOf(scr.next()));
							
							appointmentDAO.addAppointment(newAppointment);
							break;
							
					case 2:
							List<Appointment> appointments = appointmentDAO.getAllAppointment();
							System.out.println("+----------+---------------+----------------+------------------+-------------+");
							System.out.println("|    ID    |   Doctor ID   |   Patient ID   |       Date       |    Time     |");
							System.out.println("+----------+---------------+----------------+------------------+-------------+");
							for(Appointment appointment : appointments) {
								System.out.printf("|     %-5d|       %-8d|        %-8d|    %-14s|   %-10s|\n",appointment.getAppointmentId(), appointment.getDoctorId(), appointment.getPatientId(), appointment.getAppointmentDate(), appointment.getAppointmentTime());
								System.out.println("+----------+---------------+----------------+------------------+-------------+");
							}
							break;
							
					case 3:
						  	System.out.print("Enter appointment ID to view: ");
						  	int appointmentId = scr.nextInt();
						  	
						  	Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
						  	if(appointment != null) {
						  		System.out.println("+----------+---------------+----------------+------------------+-------------+");
								System.out.println("|    ID    |   Doctor ID   |   Patient ID   |       Date       |    Time     |");
								System.out.println("+----------+---------------+----------------+------------------+-------------+");
								System.out.printf("|     %-5d|       %-8d|        %-8d|    %-14s|   %-10s|\n",appointment.getAppointmentId(), appointment.getDoctorId(), appointment.getPatientId(), appointment.getAppointmentDate(), appointment.getAppointmentTime());
								System.out.println("+----------+---------------+----------------+------------------+-------------+");
						  	}
						  	else {
						  		System.out.println("Appointment not found.");
						  	}
						  	break;
						  	
					case 4:
							Appointment updateAppointment = new Appointment();
							
							System.out.print("Enter appointment ID to update: ");
							updateAppointment.setAppointmentId(scr.nextInt());
							System.out.print("Enter new doctor ID: ");
							updateAppointment.setDoctorId(scr.nextInt());
							System.out.print("Enter new patient ID: ");
							updateAppointment.setPatientId(scr.nextInt());
							System.out.print("Enter new appointment date (YYYY-MM-DD): ");
							updateAppointment.setAppointmentDate(Date.valueOf(scr.next()));
							System.out.print("Enter new appointment time (HH:MM:SS): ");
							updateAppointment.setAppointmentTime(Time.valueOf(scr.next()));
							
							appointmentDAO.updateAppointment(updateAppointment);
							break;
							
					case 5:
							System.out.print("Enter appointment ID to delete: ");
							int deleteAppointmentId = scr.nextInt();
							
							appointmentDAO.deleteAppointment(deleteAppointmentId);
							break;
							
					case 6:
							manageAppointmentRunning = false;
							System.out.println("Returning to the main menu...");
							break;
							
					default:
							System.out.println("Invalid option.");
			}
		}
	}
}
