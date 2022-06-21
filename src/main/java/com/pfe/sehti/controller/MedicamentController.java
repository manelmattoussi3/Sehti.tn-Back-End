package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Medicament;
import com.pfe.sehti.service.IMedicamentService;

@RestController
public class MedicamentController {
@Autowired
IMedicamentService medserv;
@PostMapping("/addMedicament")
public String addMedicament(@RequestBody Medicament m) {
	return medserv.addMedicament(m);
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/findAllMedicament")
public List<Medicament> findAllMedicament() {
	return medserv.findAllMedicament();
}
}
