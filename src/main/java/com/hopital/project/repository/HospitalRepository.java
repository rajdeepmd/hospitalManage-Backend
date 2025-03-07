package com.hopital.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hopital.project.mapper.HospitalProjection;
import com.hopital.project.tables.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	@Query(value = "select h.id as id, location as location, h.name as name, d.name as adminName ,d.specialization as specialization,d.email_id as emailId\r\n"
			+ " from hospitals h left join doctors d on d.hospital_id=h.id and d.role='ADMIN' group by h.id", nativeQuery = true)
	List<HospitalProjection> getHospitalWithAdmin();
}
