package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.PatientDAO;
import com.entities.Patient;
import com.utility.DatabaseConnection;

public class PatientDAOImpl implements PatientDAO{
	
	@Override
	public void addPatient(Patient patient) {
		String query = "INSERT INTO patients (name, age, contact_number, address) VALUES(?, ?, ?, ?)";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, patient.getName());
			pstmt.setInt(2, patient.getAge());
			pstmt.setString(3, patient.getContactNumber());
			pstmt.setString(4, patient.getAddress());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Patient is added successfully.");
			}
			else {
				System.out.println("Sorry! Failed to add the patient.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Patient> getAllPatients(){
		String query = "SELECT * FROM patients";
		ArrayList<Patient> patients = new ArrayList<>();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Patient patient = new Patient();
				patient.setPatientId(rs.getInt("patient_id"));
				patient.setName(rs.getString("name"));
				patient.setAge(rs.getInt("age"));
				patient.setContactNumber(rs.getString("contact_number"));
				patient.setAddress(rs.getString("address"));
				patients.add(patient);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return patients;
	}
	
	@Override
	public Patient getPatientById(int patientId) {
		String query = "SELECT * FROM patients WHERE patient_id = ?";
		Patient patient = null;
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, patientId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				patient = new Patient();
				patient.setPatientId(rs.getInt("patient_id"));
				patient.setName(rs.getString("name"));
				patient.setAge(rs.getInt("age"));
				patient.setContactNumber(rs.getString("contact_number"));
				patient.setAddress(rs.getString("address"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return patient;
	}
	
	@Override
	public void updatePatient(Patient patient) {
		String query = "UPDATE patients SET name = ?, age = ?, contact_number = ?, address = ? WHERE patient_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, patient.getName());
			pstmt.setInt(2, patient.getAge());
			pstmt.setString(3, patient.getContactNumber());
			pstmt.setString(4, patient.getAddress());
			pstmt.setInt(5, patient.getPatientId());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Patient details are update successfully.");
			}
			else {
				System.out.println("Sorry! unable to update the details of patient.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletePatient(int patientId) {
		String query = "DELETE FROM patients WHERE patient_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, patientId);
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Patient deleted successfully.");
			}
			else {
				System.out.println("Sorry! Failed to delete the patient.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
