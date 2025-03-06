package com.hopital.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hopital.project.mapper.DoctorProjection;
import com.hopital.project.tables.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT d.id, d.name, d.specialization FROM doctors d WHERE d.hospital_id = :hospitalId", nativeQuery = true)
	List<DoctorProjection> findByHospitalId(@Param("hospitalId") Long hospitalId);

	@Query(value = "SELECT d.id, d.name, d.specialization, d.role, d.email_id, d.hospital_id AS hospitalId "
			+ "FROM doctors d WHERE d.email_id = :emailId AND d.password = :pass LIMIT 1", nativeQuery = true)
	DoctorProjection login(@Param("emailId") String emailId, @Param("pass") String pass);
}
