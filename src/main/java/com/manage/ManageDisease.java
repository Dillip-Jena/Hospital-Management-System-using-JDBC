package com.manage;

import java.util.List;
import java.util.Scanner;

import com.dao.DiseaseDAO;
import com.entities.Disease;

public class ManageDisease {
	public void manageDisease(DiseaseDAO diseaseDAO, Scanner scr) {
		boolean manageDiseaseRunning = true;
		
		while(manageDiseaseRunning) {
			System.out.println("\n-----------Manage Diseases-------------");
			System.out.println("1. Add Disease");
			System.out.println("2. View All Diseases");
			System.out.println("3. View Disease by ID");
			System.out.println("4. Update Disease");
			System.out.println("5. Delete Disease");
			System.out.println("6. Go Back to Main Menu");
			
			System.out.print("\nSelect an option: ");
			int choice = scr.nextInt();
			
			switch(choice) {
					case 1:
							Disease newDisease = new Disease();
							
							System.out.print("Enter patient id: ");
							newDisease.setPatientId(scr.nextInt());
							System.out.print("Enter disease name: ");
							newDisease.setDiseaseName(scr.next());
							System.out.print("Enter status: ");
							newDisease.setStatus(scr.next());
							
							diseaseDAO.addDisease(newDisease);
							break;
							
					case 2:
							List<Disease> diseases = diseaseDAO.getAllDiseases();
							System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
							System.out.println("|   ID   |  patient_id  |   patient_name  |  patient_age |   disease_name  |    status   |");
							System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
							for(Disease disease : diseases) {
								System.out.printf("|   %-5d|      %-8d|   %-14s|      %-8d|   %-14s|  %-11s|\n", disease.getDiseaseId(), disease.getPatientId(), disease.getPatientName(), disease.getPatientAge(), disease.getDiseaseName(), disease.getStatus());
								System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
							}
							break;
							
					case 3:
							System.out.print("Enter disease ID: ");
							int diseaseId = scr.nextInt();
							
							Disease disease = diseaseDAO.getDiseaseById(diseaseId);
							if(disease != null) {
								System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
								System.out.println("|   ID   |  patient_id  |   patient_name  |  patient_age |   disease_name  |    status   |");
								System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
								System.out.printf("|   %-5d|      %-8d|   %-14s|      %-8d|   %-14s|  %-11s|\n", disease.getDiseaseId(), disease.getPatientId(), disease.getPatientName(), disease.getPatientAge(), disease.getDiseaseName(), disease.getStatus());
								System.out.println("+--------+--------------+-----------------+--------------+-----------------+-------------+");
							}
							else {
								System.out.println("Disease not found");
							}
							break;
							
					case 4:
							Disease updateDisease = new Disease();
							
							System.out.print("Enter disease ID to update: ");
							updateDisease.setDiseaseId(scr.nextInt());
							System.out.print("Enter pateint ID: ");
							updateDisease.setPatientId(scr.nextInt());
							System.out.print("Enter disease: ");
							updateDisease.setDiseaseName(scr.next());
							System.out.print("Enter current status: ");
							updateDisease.setStatus(scr.next());
							
							diseaseDAO.updateDisease(updateDisease);
							break;
							
					case 5:
							System.out.print("Enter disease ID to delete: ");
							int deletePatientId = scr.nextInt();
							
							diseaseDAO.deleteDisease(deletePatientId);
							break;
							
					case 6:
							manageDiseaseRunning = false;
							System.out.println("Returning to the main menu...");
							break;
							
					default:
							System.out.println("Invalid option.");
			}
		}
	}
}
