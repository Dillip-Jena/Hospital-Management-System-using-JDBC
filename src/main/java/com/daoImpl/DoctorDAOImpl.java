package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DoctorDAO;
import com.entities.Doctor;
import com.utility.DatabaseConnection;

public class DoctorDAOImpl implements DoctorDAO{
	
	@Override
	public void addDoctor(Doctor doctor) {
		String query = "INSERT INTO doctors(name, specialization, contact_number) VALUES(?, ?, ?)";
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, doctor.getName());
			pstmt.setString(2, doctor.getSpecialization());
			pstmt.setString(3, doctor.getContactNumber());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Doctor added successfully.");
			}
			else {
				System.out.println("Sorry! undable to add doctor.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Doctor> getAllDoctors(){
		ArrayList<Doctor> doctors = new ArrayList<>();
		String query = "SELECT * FROM doctors";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctor_id"));
				doctor.setName(rs.getString("name"));
				doctor.setSpecialization(rs.getString("specialization"));
				doctor.setContactNumber(rs.getString("contact_number"));
				doctors.add(doctor);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return doctors;
	}
	
	@Override
	public Doctor getDoctorById(int doctorId) {
		String query = "SELECT * FROM doctors WHERE doctor_id = ?";
		Doctor doctor = null;
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, doctorId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctor_id"));
				doctor.setName(rs.getString("name"));
				doctor.setSpecialization(rs.getString("specialization"));
				doctor.setContactNumber(rs.getString("contact_number"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return doctor;
	}
	
	@Override
	public void updateDoctor(Doctor doctor) {
		String query = "UPDATE doctors SET name = ?, specialization = ?, contact_number = ? WHERE doctor_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, doctor.getName());
			pstmt.setString(2, doctor.getSpecialization());
			pstmt.setString(3, doctor.getContactNumber());
			pstmt.setInt(4, doctor.getDoctorId());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Doctor updated successfully.");
			}
			else {
				System.out.println("Sorry! Unable to update the doctor.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDoctor(int doctorId) {
		String query = "DELETE FROM doctors WHERE doctor_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, doctorId);
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Doctor deleted successfully");
			}
			else {
				System.out.println("Sorry! unable to delete doctor.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
