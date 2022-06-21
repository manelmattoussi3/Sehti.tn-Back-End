package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.Medicament;

public interface IMedicamentService {
public String addMedicament(Medicament m);
public List<Medicament> findAllMedicament();
}
