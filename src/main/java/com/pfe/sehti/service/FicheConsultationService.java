package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Certificat;
import com.pfe.sehti.entity.Consultation;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.FicheConsultation;
import com.pfe.sehti.entity.LettreConfidentielle;
import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.repository.ICertificatRepository;
import com.pfe.sehti.repository.IConsultationRepository;
import com.pfe.sehti.repository.IDossierMedicalRepository;
import com.pfe.sehti.repository.IFicheConsultationRepository;
import com.pfe.sehti.repository.IOperationAnalyseRepository;
import com.pfe.sehti.repository.IOperationRadioRepository;
import com.pfe.sehti.repository.IOrdonanaceRepository;
import com.pfe.sehti.repository.IPatientRepository;


@Service
public class FicheConsultationService implements IFicheConsultationService{
@Autowired
IFicheConsultationRepository ficherep;
@Autowired
IOperationAnalyseRepository oprep;
@Autowired
IOperationRadioRepository opRadiorep;
@Autowired
IDossierMedicalRepository dosrep;
@Autowired
IConsultationRepository consultationrep;
@Autowired
IOrdonanaceRepository ordonanceRepo;
@Autowired
ICertificatRepository certifRepo;
@Autowired
IPatientRepository patientRep;
	@Override
	public String addFiche(FicheConsultation fiche) {
	ficherep.save(fiche);
		return "fiche est ajouté";
	}

	@Override
	public OperationAnalyse getOperationsAnalyse(String idFiche) {
		FicheConsultation fiche =ficherep.findById(idFiche).get();
		OperationAnalyse o =fiche.getAnalyse();
		return o;
	}
	@Override
	public OperationRadio getOperationsRadio(String idFiche) {
		FicheConsultation fiche =ficherep.findById(idFiche).get();
		OperationRadio o =fiche.getRadio();
		return o;
	}

	@Override
	public String AjouterObservation (String observation , String idFiche) {
		FicheConsultation fiche =ficherep.findById(idFiche).get();
		fiche.setObservation(observation);
		ficherep.save(fiche);
		return "Observation est ajoutée avec succé";
	}

	@Override
	public void PartagerAnalyse(OperationAnalyse analyse,String idFiche) {
		analyse.setDateAnalyse(new Date());
		oprep.save(analyse);
		FicheConsultation fiche =ficherep.findById(idFiche).get();
		
			fiche.setAnalyse(analyse);
			ficherep.save(fiche);
		//return "l'analyse est partagé avec succé";
	}

	@Override
	public void PartagerRadio(OperationRadio radio,String idFiche) {
		radio.setDateOperation(new Date());
		opRadiorep.save(radio);
		FicheConsultation fiche =ficherep.findById(idFiche).get();
			fiche.setRadio(radio);
			ficherep.save(fiche);
		
		
	}

	@Override
	public String PartagerOrdonance(Ordonance ordonance,String idPatient) {
		
		return null;
	}

	@Override
	public List<FicheConsultation> findAllFiches() {
		
		return ficherep.findAll();
	}

	@Override
	public void PartagerConsultation(Consultation consultation,String idFiche,String idOrdonance,String idCertificat) {
		Ordonance o = ordonanceRepo.findById(idOrdonance).get();
		Certificat ce =certifRepo.findById(idCertificat).get();
		consultation.setCertificat(ce);
		consultation.setOrdonance(o);
		consultationrep.save(consultation);
		FicheConsultation fiche =ficherep.findById(idFiche).get();
			fiche.setConsultation(consultation);
			ficherep.save(fiche);
		
		
		
	}

	@Override
	public FicheConsultation findFicheById(String idFiche) {
		
		return ficherep.findById(idFiche).get();
	}

	@Override
	public List<FicheConsultation> getFicheByDossier(String idDossier) {
		DossierMedical d=dosrep.findById(idDossier).get();
		return d.getFiche();
	}

	@Override
	public Consultation getConsultationByFiche(String idFiche) {
	FicheConsultation fiche =ficherep.findById(idFiche).get();	
		return fiche.getConsultation();
	}

	@Override
	public List<FicheConsultation> getFichesByIdPatient(String idPatient) {
		Patient p = patientRep.findById(idPatient).get();
		DossierMedical d =p.getDossier();
		
		return d.getFiche();
	}

	@Override
	public List<FicheConsultation> findByPatient(String idPatient) {
		
		return ficherep.findByPatient(idPatient);
	}
}
