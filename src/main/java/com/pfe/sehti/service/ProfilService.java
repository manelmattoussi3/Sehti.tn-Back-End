package com.pfe.sehti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.sehti.entity.Profil;
import com.pfe.sehti.repository.IProfilRepository;

@Service
public class ProfilService implements IProfilService{
@Autowired
IProfilRepository profilrep;
	@Override
	public List<Profil> findAllProfil() {
		
		return profilrep.findAll();
	}

	@Override
	public String AjouterProfil(Profil p) {
		profilrep.save(p);
		return "profil est ajouté";
	}

}
