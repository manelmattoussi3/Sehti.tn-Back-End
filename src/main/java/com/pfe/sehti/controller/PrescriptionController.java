package com.pfe.sehti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Prescription;
import com.pfe.sehti.service.IPrescriptinService;

@RestController
public class PrescriptionController {
@Autowired
IPrescriptinService preserv;
@PostMapping("prescrireOrdonance/Medicament/{idmed}/Demande/{idDemande}")
public String prescrireOrdonance(@RequestBody Prescription p,@PathVariable("idmed") String idMedicament,String idDemande) {
	return preserv.prescrireOrdonance(p, idMedicament,idDemande);
}
}
