package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.DemandeAcce;
import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.EtatAcce;
import com.pfe.sehti.service.IDemandeAcceService;

@RestController
@CrossOrigin(origins = "*")
public class DemandeAcceController {
@Autowired
IDemandeAcceService demandeserv;
@PostMapping("/savedemande")
public String savedemande(@RequestBody DemandeAcce d) {
	return demandeserv.savedemande(d);
}
@GetMapping("/AccederDemandesAcceEnAttentes/{idDossier}")
public List<DemandeAcce> AccederDemandesAcceEnAttentes(@PathVariable("idDossier")String idDossier){
	return demandeserv.AccederDemandesAcceEnAttentes(idDossier);
}
@PostMapping("/EnvoyerDemandeAcce/Praticien/{idPraticien}/Dossier/{idDossier}")
public String EnvoyerDemandeAcce(@PathVariable("idPraticien") String idPraticien,@PathVariable("idDossier") String idDossier ,@RequestBody DemandeAcce d) {
	return demandeserv.EnvoyerDemandeAcce(idPraticien,idDossier, d);
}

@PutMapping("/AccepterDemandeAcce/{idDemande}")
public String AccepterDemandeAcce(@PathVariable("idDemande")String idDemande) {
	return demandeserv.AccepterDemandeAcce(idDemande);
}
@PutMapping("/RefuserDemandeAcce/{idDemande}")
public String RefuserDemandeAcce(@PathVariable("idDemande") String idDemande) {
	return demandeserv.RefuserDemandeAcce(idDemande);
	
}
@PutMapping("/DonnerAccePermanent/{idDemande}")
public String DonnerAccePermanent(@PathVariable("idDemande") String idDemande) {
	return demandeserv.DonnerAccePermanent(idDemande);
}
@PutMapping("/RevoquerAccePraticien/Praticien/{idPraticien}")
public String RevoquerAccePraticien(@PathVariable("idPraticien")String idPraticien) {
	return demandeserv.RevoquerAccePraticien( idPraticien);
}
@GetMapping("/findByPraticien/{idPraticien}")
public List<DemandeAcce> findByPraticien(@PathVariable("idPraticien") String idPraticien){
	return demandeserv.findByPraticien(idPraticien);
}

@GetMapping("/findByDossierMedical/{idDossier}")
public List<DemandeAcce> findByDossierMedical(@PathVariable("idDossier") String idDossier) {
	return demandeserv.findByDossierMedical(idDossier);
}

@GetMapping("/findAllDemandes")
public List<DemandeAcce> findAllDemandes(){
	return demandeserv.findAllDemandes();
}

@GetMapping("/findByEtatDemande")
public List<DossierMedical> findByEtatDemande(){
	return demandeserv.findByEtatDemande();
}
@GetMapping("/findAllSaufPermanant")
public List<DossierMedical> findAllSaufPermanant(){
	return demandeserv.findAllSaufPermanant();
}
}
