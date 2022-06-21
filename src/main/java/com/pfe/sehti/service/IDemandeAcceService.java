package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;

public interface IDemandeAcceService {
	public String savedemande(DemandeAcce d);
	public List<DemandeAcce> AccederDemandesAcceEnAttentes(String idPatient);
	public String  EnvoyerDemandeAcce(String idPraticien,String idDossier ,DemandeAcce d);
	
	public String AccepterDemandeAcce(String idPatient);
	public String RefuserDemandeAcce(String idPatient);
	public String DonnerAccePermanent(String idPatient);
	public List<DemandeAcce> findByPraticien(String idPraticien);
	public String RevoquerAccePraticien(String idPraticien);
	public List<DemandeAcce> findAllDemandes();
	public List<DemandeAcce> findByDossierMedical(String idDossier);
	public List<DossierMedical> findByEtatDemande();
	public List<DossierMedical> findAllSaufPermanant();
	
	
}
