package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Certificat;
import com.pfe.sehti.entity.Consultation;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.service.IConsultationService;

@RestController
public class ConsultationController {
@Autowired
IConsultationService consultationServ;
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/findConsultationById/{idConsultation}")
public Consultation findConsultationById(@PathVariable("idConsultation") String idConsultation) {
	return consultationServ.findById(idConsultation);
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/findAllConsultations")
public List<Consultation> findAllConsultations() {
	return consultationServ.findAllConsultations();
}


}
