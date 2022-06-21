package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.Profil;

public interface IProfilService {
public List<Profil>findAllProfil();
public String AjouterProfil(Profil p);
}
