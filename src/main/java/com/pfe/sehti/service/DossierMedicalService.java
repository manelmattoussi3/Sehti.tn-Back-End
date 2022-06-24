package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;
import com.pfe.sehti.entity.FicheConsultation;
import com.pfe.sehti.entity.LettreConfidentielle;
import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.repository.IDemandeAcceRepository;
import com.pfe.sehti.repository.IDossierMedicalRepository;
import com.pfe.sehti.repository.IFicheConsultationRepository;
import com.pfe.sehti.repository.ILettreConfidentielleRepository;
import com.pfe.sehti.repository.IPatientRepository;
@Service
public class DossierMedicalService implements IDossierMedicalService{
@Autowired
IDossierMedicalRepository dosrep;
@Autowired
private MongoOperations mongoOperations;
@Autowired
IPatientRepository patrep;
@Autowired
IFicheConsultationRepository ficherep;
@Autowired
IDemandeAcceRepository demanderep;
@Autowired
ILettreConfidentielleRepository lettreRepo;
@Override
public List<DossierMedical> AccederDossierMedical() {
	
	return dosrep.findAll();
}
@Override
//Acceder au dossier de patient de coté patient sans demande
public List<DossierMedical> AccederDossierByPatient(String idPatient) {
	
	return dosrep.findByPatient(idPatient);

	}



@Override
//Acceder au dossier de patient de coté praticien avec demande
public DossierMedical findByPatient(String idDemande) {
//	DemandeAcce d =demanderep.findById(idDemande).get();
//	if(d.getEtat()==EtatAcce.ACCEPT || d.getEtat()==EtatAcce.PERMANENT) {
//	return dosrep.findByPatient(d.getDossierMedical().getPatient().getIdPatient());
//	}
//	else {
	return null;
	//}

}

@Override
public String save(DossierMedical d , String idPatient) {
	Patient p = patrep.findById(idPatient).get();
	d.setPatient(p);
	
	dosrep.save(d);
	return "dossier est ajoutée et affecté au patient N°"+idPatient;
}

@Override
public DossierMedical findbycodeAcce(String codeAcce) {
	
	return dosrep.findByCodeAcce(codeAcce);
}





@Override
public void PartagerLettreConfidentielle(LettreConfidentielle l ,String idDossier) {
	
	DossierMedical d =dosrep.findById(idDossier).get();
	l.setDateLettre(new Date());
	lettreRepo.save(l);
	List<LettreConfidentielle>lettres=new ArrayList<>();
if(d.getLettres()==null) {
	lettres.add(l);
	d.setLettres(lettres);
	dosrep.save(d);
}
else {
	
	d.getLettres().add(l);
	dosrep.save(d);
}

}

@Override
public void PartagerFicheConsultation(FicheConsultation fiche,String idDossier) {
	DossierMedical d =dosrep.findById(idDossier).get();
	fiche.setDateCreation(new Date());
	ficherep.save(fiche);
	List<FicheConsultation>fiches=new ArrayList<>();
if(d.getFiche()==null) {
	fiches.add(fiche);
	d.setFiche(fiches);
	dosrep.save(d);
}
else {
	
	d.getFiche().add(fiche);
	dosrep.save(d);
}
	


	
		
	
	
}
@Override
public DossierMedical findbyId(String idDossier) {
	
	return dosrep.findById(idDossier).get();
}
@Override
public List<DossierMedical> findAllDossierWithoutDemandes() {
	
	return dosrep.findAllDossierWithoutDemandes();
}
@Override
public List<DossierMedical> findAllDossierWithDemandes() {
	
	return dosrep.findAllDossierWithDemandes();
}
@Override
public DossierMedical findByDemande(String idDemande) {
	DemandeAcce de = demanderep.findById(idDemande).get();
	return de.getDossierMedical();
}

@Override
public void ModifierDossier(DossierMedical d) {


	
dosrep.save(d);
	
}



}
