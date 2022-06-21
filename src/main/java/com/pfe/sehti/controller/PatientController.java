package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.repository.IDossierMedicalRepository;
import com.pfe.sehti.repository.IPatientRepository;
import com.pfe.sehti.service.IPatientService;

@RestController
public class PatientController {
	@Autowired
	IPatientService patserv;
	@PostMapping("/savepatient")
	public ResponseEntity<String> save(@RequestBody Patient p){
		patserv.savePatient(p);
		return new ResponseEntity<String>("Data inserted",HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "AccederPatient/{idpatient}")

	public Patient AccederPatient(@PathVariable("idpatient") String idpatient) {
		//Patient p=patserv.getPatientById(idpatient);
		return patserv.getPatientById(idpatient);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findAllPatient")
	public List<Patient> findAllPatient() {
		return patserv.findAllPatient();
	}
}