package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.Patient;

public interface IPatientService {
public Patient getPatientById(String idPatient);
public String savePatient(Patient p);
public Patient findById(String idPatient);
public List<Patient> findAllPatient();
}
