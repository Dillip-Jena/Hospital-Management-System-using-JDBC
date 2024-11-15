package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.AppointmentDAO;
import com.entities.Appointment;
import com.utility.DatabaseConnection;

public class AppointmentDAOImpl implements AppointmentDAO{
	
	@Override
	public void addAppointment(Appointment appointment) {
		String query = "INSERT INTO appointments(doctor_id, patient_id, appointment_date, appointment_time) VALUES(?, ?, ?, ?)";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, appointment.getDoctorId());
			pstmt.setInt(2, appointment.getPatientId());
			pstmt.setDate(3, appointment.getAppointmentDate());
			pstmt.setTime(4, appointment.getAppointmentTime());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Appointment added successfully.");
			}
			else {
				System.out.println("Sorry! Unable to add appointment.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Appointment> getAllAppointment(){
		String query = "SELECT * FROM appointments";
		ArrayList<Appointment> appointments = new ArrayList<>();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setAppointmentId(rs.getInt("appointment_id"));
				appointment.setDoctorId(rs.getInt("doctor_id"));
				appointment.setPatientId(rs.getInt("patient_id"));
				appointment.setAppointmentDate(rs.getDate("appointment_date"));
				appointment.setAppointmentTime(rs.getTime("appointment_time"));
				appointments.add(appointment);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointments;
	}
	
	@Override
	public Appointment getAppointmentById(int appointmentId) {
		String query = "SELECT * FROM appointments WHERE appointment_id = ?";
		Appointment appointment = null;
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, appointmentId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				appointment = new Appointment();
				appointment.setAppointmentId(rs.getInt("appointment_id"));
				appointment.setDoctorId(rs.getInt("doctor_id"));
				appointment.setPatientId(rs.getInt("patient_id"));
				appointment.setAppointmentDate(rs.getDate("appointment_date"));
				appointment.setAppointmentTime(rs.getTime("appointment_time"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointment;
	}
	
	@Override
	public void updateAppointment(Appointment appointment) {
		String query = "UPDATE appointments SET doctor_id = ?, patient_id = ?, appointment_date = ?, appointment_time = ? WHERE appointment_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, appointment.getDoctorId());
			pstmt.setInt(2, appointment.getPatientId());
			pstmt.setDate(3, appointment.getAppointmentDate());
			pstmt.setTime(4, appointment.getAppointmentTime());
			pstmt.setInt(5, appointment.getAppointmentId());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Appointment is updated successfully.");
			}
			else {
				System.out.println("Sorry! Unable to update the appointment");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteAppointment(int appointmentId) {
		String query = "DELETE FROM appointments WHERE appointment_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, appointmentId);
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Appointment is deleted successfully.");
			}
			else {
				System.out.println("Sorry! Unable to delete the appointment.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
