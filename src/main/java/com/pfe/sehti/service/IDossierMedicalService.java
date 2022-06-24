package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.FicheConsultation;
import com.pfe.sehti.entity.LettreConfidentielle;
import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.entity.Patient;

public interface IDossierMedicalService {
	public List<DossierMedical> AccederDossierByPatient(String idPatient);
	public List<DossierMedical> AccederDossierMedical();
	public DossierMedical findByPatient(String idDemande);
	public String save(DossierMedical d , String idPatient);
	public DossierMedical findbycodeAcce (String codeAcce);
	public void PartagerLettreConfidentielle(LettreConfidentielle l,String idDossier);
	
	public void PartagerFicheConsultation(FicheConsultation fiche,String idDossier);
	public DossierMedical findbyId (String idDossier);
	public List<DossierMedical> findAllDossierWithoutDemandes();
	public List<DossierMedical> findAllDossierWithDemandes();
	public DossierMedical findByDemande(String idDemande);
	public void ModifierDossier(DossierMedical d);
	
}
