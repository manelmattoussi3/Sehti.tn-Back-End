package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.Certificat;

public interface ICertificatService {
public void saveCertificat(Certificat ce);
public Certificat getCertifById(String idCertif);
public List<Certificat>getAllCertificat();
}
