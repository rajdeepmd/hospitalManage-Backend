package com.hopital.project.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hopital.project.repository.PatientRepository;
import com.hopital.project.tables.Doctor;
import com.hopital.project.tables.Patient;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
    
    @GetMapping("/getPatientByDoctor/{docId}")
    public List<Patient> getPatientByDoctor(@PathVariable Long docId) {
    	Doctor doc= new Doctor();
    	doc.setId(docId);
        return patientRepository.findByDoctor(doc);
    }
}

