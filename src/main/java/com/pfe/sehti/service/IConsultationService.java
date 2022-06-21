package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.Certificat;
import com.pfe.sehti.entity.Consultation;
import com.pfe.sehti.entity.Ordonance;

public interface IConsultationService {
public Consultation findById(String idConsultation);
public List<Consultation>findAllConsultations();

}
