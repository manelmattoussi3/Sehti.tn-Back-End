package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.dom.DOMSignContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;
import com.pfe.sehti.entity.FilierePraticien;
import com.pfe.sehti.entity.LettreConfidentielle;
import com.pfe.sehti.entity.Praticien;
import com.pfe.sehti.entity.PraticienType;
import com.pfe.sehti.repository.IDemandeAcceRepository;
import com.pfe.sehti.repository.IDossierMedicalRepository;
import com.pfe.sehti.repository.ILettreConfidentielleRepository;
import com.pfe.sehti.repository.IPatientRepository;
import com.pfe.sehti.repository.IPraticienRepository;

@Service
public class LettreConfidentielleService implements ILettreConfidentielleService{
	@Autowired
	ILettreConfidentielleRepository lettreRep;
	@Autowired
	IPraticienRepository praticienRepo;
	@Autowired
	IDemandeAcceRepository demanderep;
	@Autowired
	IDossierMedicalRepository dosrep;


	@Override
	public LettreConfidentielle ConsulterLettre(String idLettre ,String idDemande) {
		DemandeAcce d =demanderep.findById(idDemande).get();
		if(d.getEtat()==EtatAcce.ACCEPT || d.getEtat()==EtatAcce.PERMANENT)  {
			LettreConfidentielle l = lettreRep.findById(idLettre).get();

			return l;

		}
		else {
			return null;
		}
	}


	@Override
	public LettreConfidentielle findLettreById(String idLettre) {
		
		return lettreRep.findById(idLettre).get();
	}


	@Override
	public List<LettreConfidentielle> findAllLettres() {
		
		return lettreRep.findAll();
	}


	@Override
	public List<LettreConfidentielle> getLettreByDossier(String idDossier) {
		DossierMedical d = dosrep.findById(idDossier).get();
		return d.getLettres();
	}
}
