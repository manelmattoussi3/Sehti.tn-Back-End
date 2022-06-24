package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.DossierMedical;
import com.pfe.sehti.entity.Medicament;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.entity.Prescription;
import com.pfe.sehti.repository.IMedicamentRepository;
import com.pfe.sehti.repository.IOrdonanaceRepository;
import com.pfe.sehti.repository.IPresecriptionRepository;

@Service
public class PrescriptionService implements IPrescriptinService{
@Autowired
IPresecriptionRepository presrepo;
@Autowired
IMedicamentRepository medrepo;
@Autowired
IOrdonanaceRepository ordoRep;
@Override
public void prescrireMedicamentEtLePartagerAUneOrdonance(Prescription p, String idMedicament,String idOrdonance) {
	
	Medicament m=medrepo.findById(idMedicament).get();
	//p.setMedicament(m);
	presrepo.save(p);
	m.setPrescription(p);
	medrepo.save(m);
	Ordonance o=ordoRep.findById(idOrdonance).get();
	List<Medicament>medicaments=new ArrayList<>();
	if(o.getMedicaments()==null) {
		medicaments.add(m);
		o.setMedicaments(medicaments);
		ordoRep.save(o);
	}
	
	else {
		o.getMedicaments().add(m);
		ordoRep.save(o);
	}
			
}
}
