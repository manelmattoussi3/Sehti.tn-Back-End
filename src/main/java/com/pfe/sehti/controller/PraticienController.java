package com.pfe.sehti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Praticien;
import com.pfe.sehti.service.IPraticienService;

@RestController
public class PraticienController {
@Autowired
IPraticienService praticienserv;
@PostMapping("/savePraticien")
public String savePraticien(@RequestBody Praticien p) {
	return praticienserv.savePraticien(p);
}
@PostMapping("/DefinirMedecinFamille")
public String DefinirMedecinFamille(@RequestBody Praticien p) {
	return praticienserv.DefinirMedecinFamille(p);
}
}
