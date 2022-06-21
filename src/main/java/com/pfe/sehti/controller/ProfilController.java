package com.pfe.sehti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sehti.entity.Profil;
import com.pfe.sehti.service.IProfilService;

@RestController
public class ProfilController {
@Autowired
IProfilService profilserv;
@GetMapping("/findAllProfil")
public List<Profil> findAllProfil() {
	return profilserv.findAllProfil();
}
@PostMapping("/AjouterProfil")
public String AjouterProfil(@RequestBody Profil p) {
	return profilserv.AjouterProfil(p);
}
}
