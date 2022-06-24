package com.pfe.sehti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Prescription;
import com.pfe.sehti.service.IPrescriptinService;

@RestController
@CrossOrigin(origins = "*")
public class PrescriptionController {
@Autowired
IPrescriptinService preserv;
@PostMapping("prescrireMedicamentEtLePartagerAUneOrdonance/medicament/{idMedicament}/ordonance/{idOrdonance}")
public void prescrireMedicamentEtLePartagerAUneOrdonance(@RequestBody Prescription p, @PathVariable("idMedicament") String idMedicament,@PathVariable("idOrdonance")String idOrdonance) {
	preserv.prescrireMedicamentEtLePartagerAUneOrdonance(p, idMedicament, idOrdonance);
}
}
