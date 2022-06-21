package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.repository.IPatientRepository;

@Service
public class PatientService implements IPatientService{
@Autowired
IPatientRepository patientrep;
	@Override
	public Patient getPatientById(String idPatient) {
		
		return patientrep.findById(idPatient).get();
	}
	@Override
	public String savePatient(Patient p) {
		patientrep.save(p);
		return "patient est ajouté";
	}
	@Override
	public Patient findById(String idPatient) {
		
		return patientrep.findById(idPatient).get();
	}
	@Override
	public List<Patient> findAllPatient() {
		
		return patientrep.findAll();
	}

}
