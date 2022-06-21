package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Medicament;
import com.pfe.sehti.repository.IMedicamentRepository;

@Service
public class MedicamentService implements IMedicamentService{
@Autowired
IMedicamentRepository medrep;
	@Override
	public String addMedicament(Medicament m) {
		medrep.save(m);
		return "medicament ajouté";
	}
	@Override
	public List<Medicament> findAllMedicament() {
		
		return medrep.findAll();
	}

}
