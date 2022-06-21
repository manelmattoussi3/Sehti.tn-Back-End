package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Consultation;
import com.pfe.sehti.entity.FicheConsultation;
import com.pfe.sehti.entity.OperationAnalyse;
import com.pfe.sehti.entity.OperationRadio;
import com.pfe.sehti.service.IFicheConsultationService;

@RestController
@CrossOrigin(origins = "*")
public class FicheConsultationController {
	@Autowired
	IFicheConsultationService ficheserv;
	@PostMapping("/addFiche")
	public String addFiche(@RequestBody FicheConsultation fiche) {
		return ficheserv.addFiche(fiche);
	}

	@GetMapping("/getOperationsAnalyse/{idFiche}")
	public OperationAnalyse getOperationsAnalyse(@PathVariable("idFiche") String idFiche) {
		return ficheserv.getOperationsAnalyse(idFiche);
	}
	@GetMapping("/getOperationsRadio/{idFiche}")
	public OperationRadio getOperationsRadio(@PathVariable("idFiche") String idFiche) {
		return ficheserv.getOperationsRadio(idFiche);
	}

	@PutMapping("/AjouterObservation/observation/{observation}/fiche/{idFiche}")
	public String AjouterObservation (@PathVariable("observation") String observation ,@PathVariable("idFiche") String idFiche) {
		return ficheserv.AjouterObservation(observation, idFiche);
	}
	@PostMapping("/PartagerAnalyse/{idFiche}")
	public void PartagerAnalyse(@RequestBody OperationAnalyse analyse,@PathVariable("idFiche") String idFiche) {
		 ficheserv.PartagerAnalyse(analyse,idFiche);
	}
	@PostMapping("/PartagerRadio/{idFiche}")
	public void PartagerRadio(@RequestBody OperationRadio radio,@PathVariable("idFiche") String idFiche) {
		 ficheserv.PartagerRadio(radio, idFiche);
	}
	
	@GetMapping("/findAllFiches")
	public List<FicheConsultation> findAllFiches(){
		return ficheserv.findAllFiches();
	}
	@PostMapping("/PartagerConsultation/fiche/{idFiche}/ordonance/{idOrdonance}/certificat/{idCertificat}")
	public void PartagerConsultation(@RequestBody Consultation consultation,@PathVariable("idFiche") String idFiche ,@PathVariable("idOrdonance") String idOrdonance,@PathVariable("idCertificat") String idCertificat) {
		 ficheserv.PartagerConsultation(consultation, idFiche ,idOrdonance ,idCertificat);
	}
	
	@GetMapping("/findFicheById/{idFiche}")
	public FicheConsultation findFicheById(@PathVariable("idFiche") String idFiche) {
		return ficheserv.findFicheById(idFiche);
	}
	
	@GetMapping("/getFicheByDossier/{idDossier}")
	public List<FicheConsultation> getFicheByDossier(@PathVariable String idDossier) {
		return ficheserv.getFicheByDossier(idDossier);
	}
	
	@GetMapping("/getConsultationByFiche/{idFiche}")
	public Consultation getConsultationByFiche(@PathVariable("idFiche") String idFiche) {
		return ficheserv.getConsultationByFiche(idFiche);
	}
	@GetMapping("/findByPatient/{idPatient}")
	public List<FicheConsultation> findByPatient(@PathVariable("idPatient")String idPatient){
		return ficheserv.findByPatient(idPatient);
	}
}
