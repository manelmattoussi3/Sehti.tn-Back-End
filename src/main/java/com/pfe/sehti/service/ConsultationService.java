package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Certificat;
import com.pfe.sehti.entity.Consultation;
import com.pfe.sehti.entity.Ordonance;
import com.pfe.sehti.repository.ICertificatRepository;
import com.pfe.sehti.repository.IConsultationRepository;
import com.pfe.sehti.repository.IOrdonanaceRepository;

@Service
public class ConsultationService implements IConsultationService{
@Autowired
IConsultationRepository consultationRep;
@Autowired
IOrdonanaceRepository ordonanceRep;
@Autowired
ICertificatRepository certifRep;
	@Override
	public Consultation findById(String idConsultation) {
		
		return consultationRep.findById(idConsultation).get();
	}
	@Override
	public List<Consultation> findAllConsultations() {
		
		return consultationRep.findAll();
	}


}
