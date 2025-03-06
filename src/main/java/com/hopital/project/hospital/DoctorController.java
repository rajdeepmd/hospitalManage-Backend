package com.hopital.project.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hopital.project.mapper.DoctorProjection;
import com.hopital.project.repository.DoctorRepository;
import com.hopital.project.tables.Doctor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping // ✅ No need for 'name' attribute
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@GetMapping("/getDoctors/{docId}") // ✅ No need for 'name' attribute
	public Optional<Doctor> getDoctors(@PathVariable Long docId) {
		System.out.println("getDoctors");
		return doctorRepository.findById(docId);
	}

	@GetMapping("/getAllDoctorList/{hospitalId}") // ✅ Use explicit path
	public List<DoctorProjection> getAllDoctorList(@PathVariable Long hospitalId) {
		System.out.println("getAllDoctorList");
		return doctorRepository.findByHospitalId(hospitalId);
	}
	
	@PostMapping("/login") // ✅ No need for 'name' attribute
	public DoctorProjection login(@RequestBody Doctor doctor) {
		return doctorRepository.login(doctor.getEmailId(),doctor.getPassword());
	}
}
