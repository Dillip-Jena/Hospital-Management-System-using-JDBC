package com.dao;

import java.util.List;

import com.entities.Disease;

public interface DiseaseDAO {
	void addDisease(Disease disease);
	List<Disease> getAllDiseases();
	Disease getDiseaseById(int id);
	void updateDisease(Disease disease);
	void deleteDisease(int id);
}
