package com.hopital.project.mapper;

public interface DoctorProjection {
	Long getId();

	String getName();

	String getSpecialization();
	
	String getRole();
	
	String getEmailId();
	
	Long getHospitalId();
}
