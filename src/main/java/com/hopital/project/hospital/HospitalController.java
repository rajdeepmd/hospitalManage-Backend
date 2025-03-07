package com.hopital.project.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hopital.project.mapper.HospitalProjection;
import com.hopital.project.repository.DoctorRepository;
import com.hopital.project.repository.HospitalRepository;
import com.hopital.project.tables.Doctor;
import com.hopital.project.tables.Hospital;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;
    
    @Autowired
	private DoctorRepository doctorRepository;

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
    	Hospital obj=hospitalRepository.save(hospital);
    	Doctor doctor= new Doctor();
    	doctor.setEmailId(hospital.getEmailId());
    	doctor.setName(hospital.getAdminName());
    	doctor.setSpecialization(hospital.getSpecialization());
    	doctor.setPassword("12345678");
    	doctor.setRole("ADMIN");
    	doctor.setHospital(obj);
    	doctorRepository.save(doctor);
        return obj;
    }

//    @GetMapping("/getHospitals")
//    public List<Hospital> getHospitals() {
//        return hospitalRepository.findAll();
//    }
    
    @GetMapping("/getHospitals")
    public List<HospitalProjection> getHospitals() {
//        return hospitalRepository.findAll();
        return hospitalRepository.getHospitalWithAdmin();
        
    }
}

