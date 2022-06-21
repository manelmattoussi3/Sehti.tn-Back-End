package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;
import com.pfe.sehti.entity.Patient;
import com.pfe.sehti.entity.Praticien;
import com.pfe.sehti.repository.IDemandeAcceRepository;
import com.pfe.sehti.repository.IDossierMedicalRepository;
import com.pfe.sehti.repository.IPatientRepository;
import com.pfe.sehti.repository.IPraticienRepository;

@Service
public class DemandeAcceService implements IDemandeAcceService{
	@Autowired
	IDemandeAcceRepository accerepo;
	@Autowired
	IPatientRepository patientrep;
	@Autowired
	IPraticienRepository praticienrep;
	@Autowired
	IDossierMedicalRepository dosrep;
	@Override
	public List<DemandeAcce> findByPraticien(String idPraticien) {

		return accerepo.findByPraticien(idPraticien);
	}
	
	@Override
	public List<DemandeAcce> AccederDemandesAcceEnAttentes(String idDossier) {
		
		DossierMedical d= dosrep.findById(idDossier).get();
		List<DemandeAcce>demandes = new ArrayList<>();
		demandes.addAll(d.getDemandesacces());
		for(DemandeAcce de :demandes) {
			if(de.getEtat()==EtatAcce.EnAttente) {
				return d.getDemandesacces();
			}
		}
		return null;
	}
	@Override
	public String savedemande(DemandeAcce d) {
		accerepo.save(d);
		return "demande est ajouté";
	}
	@Override
	public String EnvoyerDemandeAcce(String idPraticien,String idDossier ,DemandeAcce d) {
		DossierMedical dossier =dosrep.findById(idDossier).get();
		Praticien praticien =praticienrep.findById(idPraticien).get();
		
		d.setPraticien(praticien);
		d.setDossierMedical(dossier);
		d.setEtat(EtatAcce.EnAttente);
		d.setDateCreation(new Date());
		//List<DemandeAcce>demandes = new ArrayList<>();
		
		accerepo.save(d);
		//demandes.add(d);
		
		dossier.getDemandesacces().add(d);
		dosrep.save(dossier);
		
		return "la demande est envoyé avec succé";
	}
	@Override
	public String AccepterDemandeAcce(String idDemande) {
		DemandeAcce de =accerepo.findById(idDemande).get();
		de.setEtat(EtatAcce.ACCEPT);
		accerepo.save(de);
		
		return "la demande est accepté";
	}
	@Override
	public String RefuserDemandeAcce(String idDemande) {
		DemandeAcce de =accerepo.findById(idDemande).get();
		de.setEtat(EtatAcce.REFUSE);
		accerepo.save(de);
		
		return "la demande est refusé";
	}
	@Override
	public String DonnerAccePermanent(String idDemande) {
		DemandeAcce de =accerepo.findById(idDemande).get();
		de.setEtat(EtatAcce.PERMANENT);
		accerepo.save(de);
		
		return "la demande est permanent";
	}
	@Override
	public String RevoquerAccePraticien(String idPraticien) {

		List<DemandeAcce>demandes =this.findByPraticien(idPraticien);
		for(DemandeAcce d :demandes) {
			if(d.getEtat()==EtatAcce.PERMANENT) {
				d.setEtat(EtatAcce.ANNULE);
				accerepo.save(d);
			}
		}
		return "l'accé de praticien est revoqué";
	}
	@Override
	public List<DemandeAcce> findByDossierMedical(String idDossier) {
		
		return accerepo.findByDossierMedical(idDossier);
	}

	@Override
	public List<DemandeAcce> findAllDemandes() {
		
		return accerepo.findAll();
	}

	@Override
	public List<DossierMedical> findByEtatDemande() {
		
		List<DossierMedical>dossiers=new ArrayList<>();
		List<DemandeAcce>demandes=accerepo.findAll();
		//demandes.addAll();
		for(DemandeAcce de:demandes) {
			if(de.getEtat()==EtatAcce.PERMANENT) {
				dossiers.add(de.getDossierMedical());
				
				}
		}
		return dossiers;
	}

	@Override
	public List<DossierMedical> findAllSaufPermanant() {
		List<DossierMedical>dossiers=new ArrayList<>();
		List<DemandeAcce>demandes=accerepo.findAll();
		//demandes.addAll();
		for(DemandeAcce de:demandes) {
			if(de.getEtat()!=EtatAcce.PERMANENT) {
				dossiers.add(de.getDossierMedical());
				
				}
		}
		
		
		
		return dossiers;
	}




}
