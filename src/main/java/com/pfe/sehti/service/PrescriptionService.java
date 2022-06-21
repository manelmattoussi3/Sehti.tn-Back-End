package com.pfe.sehti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.Medicament;
import com.pfe.sehti.entity.Prescription;
import com.pfe.sehti.repository.IMedicamentRepository;
import com.pfe.sehti.repository.IPresecriptionRepository;

@Service
public class PrescriptionService implements IPrescriptinService{
@Autowired
IPresecriptionRepository presrepo;
@Autowired
IMedicamentRepository medrepo;
@Override
public String prescrireOrdonance(Prescription p, String idMedicament,String idDemande) {
	DossierMedicalService d = new DossierMedicalService();
	DossierMedical dossier =d.findByPatient(idDemande);
	//dossier.getFiche().getConsultation().getOrdonance().setPrescriptions(prescriptions);
	Medicament m=medrepo.findById(idMedicament).get();
	p.setMedicament(m);
	presrepo.save(p);
	
	return "inserted prescription";
			
}
}
