package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Certificat;
import com.pfe.sehti.repository.ICertificatRepository;

@Service
public class CertificatService implements ICertificatService{
@Autowired
ICertificatRepository certifRepo;
	@Override
	public void saveCertificat(Certificat ce) {
		certifRepo.save(ce);
		
	}
	@Override
	public Certificat getCertifById(String idCertif) {
		
		return certifRepo.findById(idCertif).get();
	}
	@Override
	public List<Certificat> getAllCertificat() {
		// TODO Auto-generated method stub
		return certifRepo.findAll();
	}

}
