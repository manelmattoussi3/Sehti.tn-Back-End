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

import com.pfe.sehti.entity.EtatOrdonance;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.service.IOrdonanceService;

@RestController
public class OrdonanceController {
@Autowired
IOrdonanceService ordonserv;
@GetMapping("/ConsulterOrdonancesActives")
public List<Ordonance>ConsulterOrdonancesActives(){
	return ordonserv.ConsulterOrdonancesActives();
}
@PostMapping("/saveOrdonance")
public String saveOrdonance(@RequestBody Ordonance o) {
	return ordonserv.saveOrdonance(o);
}
@PutMapping("/NouveauteOrdonance/{idOrdon}")
public String NouveauteOrdonance(@PathVariable ("idOrdon")String idOrdonance) {
	return ordonserv.NouveauteOrdonance(idOrdonance);
}
@GetMapping("/AccederNouveauxOrdonances")
public List<Ordonance> AccederNouveauxOrdonances(){
	return ordonserv.AccederNouveauxOrdonances();
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/findAllOrdonances")
public List<Ordonance> findAllOrdonances(){
	return ordonserv.findAllOrdonances();
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/findOrdonanceById/{idOrdon}")
public Ordonance findOrdonanceById(@PathVariable ("idOrdon") String idOrdonance) {
	return ordonserv.findOrdonanceById(idOrdonance);
}
}
