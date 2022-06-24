package com.pfe.sehti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.EtatOrdonance;
import com.pfe.sehti.entity.Medicament;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.entity.Prescription;
import com.pfe.sehti.repository.IMedicamentRepository;
import com.pfe.sehti.repository.IOrdonanaceRepository;
import com.pfe.sehti.repository.IPresecriptionRepository;

@Service
public class OrdonanceService implements IOrdonanceService{
@Autowired
IOrdonanaceRepository ordonrep;
@Autowired
IPresecriptionRepository presecriptionRep;
@Autowired
IMedicamentRepository medRep;
	@Override
	public List<Ordonance> ConsulterOrdonancesActives() {
	
		return ordonrep.ConsulterOrdonancesActives();
	}
	@Override
	public void saveOrdonance(Ordonance o) {

		
		ordonrep.save(o);
		
	}
	@Override
	public String NouveauteOrdonance(String idOrdonance) {
		Ordonance o =ordonrep.findById(idOrdonance).get();
		if(new Date().getTime()-o.getDateOrdonance().getTime()<=48) {
			o.setNouveaute(true);
			ordonrep.save(o);
			return "l'ordonance est nouvelle";
		}
		else {
			o.setNouveaute(false);
			ordonrep.save(o);
		return "l'ordonance est ancienne";
		}
	}
	@Override
	public List<Ordonance> AccederNouveauxOrdonances() {
		
		return ordonrep.AccederNouveauxOrdonances();
	}
	@Override
	public List<Ordonance> findAllOrdonances() {
		
		return ordonrep.findAll();
	}
	@Override
	public Ordonance findOrdonanceById(String idOrdonance) {
		
		return ordonrep.findById(idOrdonance).get();
	}

}
