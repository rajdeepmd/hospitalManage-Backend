package com.hopital.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopital.project.tables.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}

