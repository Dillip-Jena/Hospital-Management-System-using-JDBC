package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.DiseaseDAO;
import com.entities.Disease;
import com.utility.DatabaseConnection;

public class DiseaseDAOImpl implements DiseaseDAO{
	@Override
	public void addDisease(Disease disease) {
		String query = "INSERT INTO diseases(patient_id, disease_name, current_status) VALUES(?, ?, ?)";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, disease.getPatientId());
			pstmt.setString(2, disease.getDiseaseName());
			pstmt.setString(3, disease.getStatus());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Disease is added successfully.");
			}
			else {
				System.out.println("Sorry! Failed to add the disease.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Disease> getAllDiseases(){
		String query = "SELECT d.disease_id, d.patient_id, d.disease_name, d.current_status, p.name AS patient_name, p.age AS patient_age "+
						"FROM diseases d "+
						"JOIN patients p ON d.patient_id = p.patient_id";
		List<Disease> diseases = new ArrayList<>();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Disease disease = new Disease();
				disease.setDiseaseId(rs.getInt("disease_id"));
				disease.setPatientId(rs.getInt("patient_id"));
				disease.setDiseaseName(rs.getString("disease_name"));
				disease.setStatus(rs.getString("current_status"));
				disease.setPatientName(rs.getString("patient_name"));
				disease.setPatientAge(rs.getInt("patient_age"));
				diseases.add(disease);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return diseases;
	}
	
	@Override
	public Disease getDiseaseById(int id) {
		String query = "SELECT d.disease_id, d.patient_id, d.disease_name, d.current_status, p.name AS patient_name, p.age AS patient_age "+
						"FROM diseases d "+
						"JOIN patients p ON d.patient_id = p.patient_id "+
						"WHERE d.disease_id = ?";
		Disease disease = null;
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				disease = new Disease();
				disease.setDiseaseId(rs.getInt("disease_id"));
				disease.setPatientId(rs.getInt("patient_id"));
				disease.setDiseaseName(rs.getString("disease_name"));
				disease.setStatus(rs.getString("current_status"));
				disease.setPatientName(rs.getString("patient_name"));
				disease.setPatientAge(rs.getInt("patient_age"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return disease;
	}
	
	@Override
	public void updateDisease(Disease disease) {
		String query = "UPDATE diseases SET patient_id = ?, disease_name = ?, current_status = ? WHERE disease_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, disease.getPatientId());
			pstmt.setString(2, disease.getDiseaseName());
			pstmt.setString(3, disease.getStatus());
			pstmt.setInt(4, disease.getDiseaseId());
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Disease details are update successfully.");
			}
			else {
				System.out.println("Sorry! unable to update the details of disease.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteDisease(int id) {
		String query = "DELETE FROM diseases WHERE disease_id = ?";
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			
			int rowAffect = pstmt.executeUpdate();
			if(rowAffect > 0) {
				System.out.println("Disease details are delete successfully.");
			}
			else {
				System.out.println("Sorry! Failed to delete the disease.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
