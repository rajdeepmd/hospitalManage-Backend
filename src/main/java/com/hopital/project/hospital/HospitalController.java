package com.hopital.project.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hopital.project.repository.HospitalRepository;
import com.hopital.project.tables.Hospital;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @GetMapping("/getHospitals")
    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }
}

