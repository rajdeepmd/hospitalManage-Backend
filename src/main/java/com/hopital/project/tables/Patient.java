package com.hopital.project.tables;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int age;
	
	private String disease;

	@CreationTimestamp
	private Timestamp createdDate;

	private LocalDate revisiteDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	private String contactNo;
	
	// Constructors
	public Patient() {
	}

	public Patient(String name, int age, Doctor doctor) {
		this.name = name;
		this.age = age;
		this.doctor = doctor;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getRevisiteDate() {
		return revisiteDate;
	}

	public void setRevisiteDate(LocalDate revisiteDate) {
		this.revisiteDate = revisiteDate;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
