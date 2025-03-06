package com.hopital.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hopital.project.tables.Doctor;
import com.hopital.project.tables.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	List<Patient> findByDoctor(@Param("doctorId") Doctor doctorId);
}
