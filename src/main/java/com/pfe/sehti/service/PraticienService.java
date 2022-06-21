package com.pfe.sehti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.FilierePraticien;
import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.entity.Praticien;
import com.pfe.sehti.entity.PraticienType;
import com.pfe.sehti.repository.IDemandeAcceRepository;
import com.pfe.sehti.repository.IPatientRepository;
import com.pfe.sehti.repository.IPraticienRepository;

@Service
public class PraticienService implements IPraticienService{
@Autowired
IPraticienRepository praticienrep;
@Autowired
IPatientRepository patientrep;
@Autowired
IDemandeAcceRepository demandeRep;
	@Override
	public String savePraticien(Praticien p) {
		praticienrep.save(p);
		return "praticien est ajouté";
	}
	@Override
	public String DefinirMedecinFamille(Praticien p) {
		//acce permanant
		p.setType(PraticienType.MEDECIN);
		p.setFiliere(FilierePraticien.FAMILLE);
		praticienrep.save(p);
		
		return "vous avez ajouté un médecin de famille avec succé";
	}
	

}
